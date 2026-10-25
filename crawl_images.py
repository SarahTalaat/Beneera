import urllib.request
import re
import os
import json

base_url = "https://beneera.com"
pages = ["/", "/shop"]

all_img_urls = set()

for p in pages:
    try:
        req = urllib.request.Request(base_url + p, headers={"User-Agent": "Mozilla/5.0"})
        html = urllib.request.urlopen(req).read().decode("utf-8")
        urls = re.findall(r'src="([^"]+)"', html)
        for link in urls:
            if any(link.endswith(ext) for ext in [".webp", ".png", ".jpg", ".jpeg", ".svg"]):
                if link.startswith("/"):
                    link = base_url + link
                elif not link.startswith("http"):
                    continue
                all_img_urls.add(link)
    except Exception as e:
        print(f"Error crawling {p}: {e}")

print(f"Discovered {len(all_img_urls)} unique image URLs.")
out_dir = os.path.expanduser("~/beneera-android/app/src/main/assets/beneera/images/")
os.makedirs(os.path.join(out_dir, "branding"), exist_ok=True)
os.makedirs(os.path.join(out_dir, "home"), exist_ok=True)
os.makedirs(os.path.join(out_dir, "categories"), exist_ok=True)
os.makedirs(os.path.join(out_dir, "products"), exist_ok=True)
os.makedirs(os.path.join(out_dir, "banners"), exist_ok=True)

manifest = []

for i, img_url in enumerate(sorted(all_img_urls)):
    try:
        req = urllib.request.Request(img_url, headers={"User-Agent": "Mozilla/5.0"})
        data = urllib.request.urlopen(req).read()

        # Determine category folder
        if "brand" in img_url or "mark" in img_url:
            sub = "branding"
        elif "home" in img_url and "hero" in img_url:
            sub = "home"
        elif "category" in img_url:
            sub = "categories"
        elif "uploads/products" in img_url:
            sub = "products"
        else:
            sub = "banners"

        filename = os.path.basename(img_url.split("?")[0])
        if not filename:
            filename = f"img_{i}.webp"

        local_path = f"app/src/main/assets/beneera/images/{sub}/{filename}"
        full_dest = os.path.expanduser(f"~/beneera-android/{local_path}")

        with open(full_dest, "wb") as f:
            f.write(data)

        manifest.append({
            "original_url": img_url,
            "local_path": local_path,
            "category": sub,
            "filename": filename,
            "size_bytes": len(data)
        })
        print(f"Downloaded {img_url} -> {local_path} ({len(data)} bytes)")
    except Exception as e:
        print(f"Failed {img_url}: {e}")

manifest_path = os.path.expanduser("~/beneera-android/app/src/main/assets/beneera/image_manifest.json")
with open(manifest_path, "w") as f:
    json.dump(manifest, f, indent=2)

print(f"Saved manifest with {len(manifest)} entries to {manifest_path}")

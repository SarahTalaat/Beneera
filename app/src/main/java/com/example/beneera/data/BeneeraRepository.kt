package com.example.beneera.data

object BeneeraRepository {
    val categories = listOf(
        Category(
            id = "dog-supplies",
            name = "Dog Supplies",
            description = "Everything your canine companion needs for a happy, healthy life.",
            iconName = "ic_dog",
            imageUrl = "category_dog_supplies"
        ),
        Category(
            id = "cat-supplies",
            name = "Cat Supplies",
            description = "Premium essentials for your feline friends, from scratchers to cozy beds.",
            iconName = "ic_cat",
            imageUrl = "category_cat_supplies"
        ),
        Category(
            id = "pet-grooming",
            name = "Pet Grooming",
            description = "Keep coats shiny, paws clean, and tails wagging with gentle grooming tools.",
            iconName = "ic_grooming",
            imageUrl = "category_pet_grooming"
        ),
        Category(
            id = "pet-feeding",
            name = "Feeding & Watering",
            description = "Ergonomic bowls, slow feeders, and stainless steel water fountains.",
            iconName = "ic_bowl",
            imageUrl = "category_feeding_watering"
        ),
        Category(
            id = "pet-toys",
            name = "Pet Toys",
            description = "Engaging puzzle toys, plush chewers, and interactive lasers.",
            iconName = "ic_toy",
            imageUrl = "category_pet_toys"
        ),
        Category(
            id = "pet-beds",
            name = "Beds & Furniture",
            description = "Orthopedic memory foam beds and stylish modern pet lounges.",
            iconName = "ic_bed",
            imageUrl = "category_pet_beds_furniture"
        ),
        Category(
            id = "pet-travel",
            name = "Travel & Carriers",
            description = "Airline-approved carriers, car seat belts, and portable water bottles.",
            iconName = "ic_travel",
            imageUrl = "category_travel_carriers"
        ),
        Category(
            id = "pet-cleaning",
            name = "Cleaning & Odor Control",
            description = "Pet-safe enzymatic cleaners, waste bags, and odor eliminators.",
            iconName = "ic_cleaning",
            imageUrl = "category_cleaning_odor"
        )
    )

    val products = listOf(
        Product(
            id = "beneera-orthopedic-bed",
            name = "Beneera Orthopedic Memory Foam Dog Bed",
            category = "Beds & Furniture",
            price = 69.99,
            originalPrice = 89.99,
            rating = 4.9,
            reviewCount = 312,
            imageUrl = "hcdzrxsoodyj5qg0hdez",
            description = "Designed for ultimate joint support, this orthopedic memory foam dog bed relieves pressure points and provides restorative sleep for dogs of all sizes. Features a removable, machine-washable waterproof cover.",
            specifications = listOf(
                "Material" to "High-density memory foam & plush sherpa",
                "Sizes" to "Medium (30\"x20\"), Large (40\"x30\"), Extra Large (50\"x36\")",
                "Care" to "Machine washable removable cover",
                "Warranty" to "1-Year Manufacturer Warranty"
            ),
            variants = listOf("Medium - Gray", "Large - Gray", "Extra Large - Charcoal"),
            isFeatured = true,
            isOnSale = true
        ),
        Product(
            id = "beneera-stainless-fountain",
            name = "Beneera Stainless Steel Pet Water Fountain",
            category = "Feeding & Watering",
            price = 39.99,
            originalPrice = 49.99,
            rating = 4.8,
            reviewCount = 189,
            imageUrl = "fvcuinszpncstzktqibc",
            description = "Encourage your pets to drink more fresh, oxygenated water with the ultra-quiet Beneera 2.5L Stainless Steel Pet Water Fountain. Triple-action filtration removes hair, heavy metals, and odors.",
            specifications = listOf(
                "Capacity" to "2.5 Liters / 84 oz",
                "Material" to "BPA-Free Food Grade Stainless Steel",
                "Pump" to "Submersible ultra-quiet LED low-voltage pump",
                "Filter" to "Activated carbon & ion exchange resin"
            ),
            variants = listOf("Standard 2.5L", "Smart Wi-Fi 3.0L"),
            isFeatured = true,
            isNewArrival = true
        ),
        Product(
            id = "beneera-interactive-laser",
            name = "Beneera Smart Automatic Laser Cat Toy",
            category = "Pet Toys",
            price = 24.99,
            rating = 4.7,
            reviewCount = 95,
            imageUrl = "qg8k7txibft8rwxq24on",
            description = "Keep your indoor cats active and entertained for hours with adjustable speed and random 360-degree rotation laser patterns. USB rechargeable with automatic shut-off feature.",
            specifications = listOf(
                "Modes" to "Slow, Fast, Random, and Manual",
                "Power" to "Rechargeable Li-ion battery (USB-C cable included)",
                "Safety" to "Class 2 medical-grade safe laser",
                "Timer" to "Auto-off after 15 minutes"
            ),
            variants = listOf("White", "Teal"),
            isFeatured = true
        ),
        Product(
            id = "beneera-grooming-vacuum",
            name = "Beneera Pet Grooming Kit & Deshedding Vacuum",
            category = "Pet Grooming",
            price = 89.99,
            originalPrice = 119.99,
            rating = 4.9,
            reviewCount = 240,
            imageUrl = "kafbb7tvwjpvkzwvjjs7",
            description = "An all-in-one grooming solution that suctions 99% of pet hair directly into a vacuum canister while you brush and trim. Includes 5 professional grooming tools and adjustable suction levels.",
            specifications = listOf(
                "Noise Level" to "Low decibel quiet motor (<60dB)",
                "Dust Cup" to "1.4 Liter easy-empty container",
                "Attachments" to "Deshedding brush, electric clipper, cleaning nozzle, slicker brush",
                "Hose Length" to "1.5 meters flexible hose"
            ),
            variants = listOf("Standard Kit", "Pro Kit with Extra Blades"),
            isFeatured = true,
            isOnSale = true
        ),
        Product(
            id = "beneera-airline-carrier",
            name = "Beneera Premium Airline-Approved Pet Carrier",
            category = "Travel & Carriers",
            price = 45.99,
            rating = 4.8,
            reviewCount = 156,
            imageUrl = "w5pobjhvrj8apylm9ccw",
            description = "Travel in style and comfort with breathable mesh ventilation on all sides, a sturdy structured frame that fits under airplane seats, and a cozy faux-lambskin removable bedding pad.",
            specifications = listOf(
                "Dimensions" to "17\" L x 10\" W x 10\" H",
                "Weight Limit" to "Up to 16 lbs",
                "Material" to "Water-resistant 600D polyester",
                "Airline Compliant" to "Fits major airline seat dimensions"
            ),
            variants = listOf("Black", "Navy Blue", "Heather Gray"),
            isNewArrival = true
        ),
        Product(
            id = "beneera-enzyme-cleaner",
            name = "Beneera Bio-Enzymatic Pet Stain & Odor Remover",
            category = "Cleaning & Odor Control",
            price = 19.99,
            originalPrice = 24.99,
            rating = 4.9,
            reviewCount = 420,
            imageUrl = "zso3vfdlkhajfi2r8qdh",
            description = "Formulated with powerful natural bio-enzymes that permanently target and breakdown tough urine stains, feces, and vomit odors at the molecular level on carpets, rugs, and upholstery.",
            specifications = listOf(
                "Volume" to "32 fl oz spray bottle",
                "Formula" to "Eco-friendly, non-toxic, pet & child safe",
                "Scent" to "Light citrus freshness",
                "Surfaces" to "Carpets, hardwood, tile, upholstery, bedding"
            ),
            variants = listOf("32 oz Spray", "128 oz Refill Jug"),
            isNewArrival = true,
            isOnSale = true
        ),
        Product(
            id = "beneera-dog-raincoat",
            name = "Beneera Waterproof Reflective Dog Raincoat",
            category = "Dog Supplies",
            price = 22.99,
            rating = 4.6,
            reviewCount = 88,
            imageUrl = "m9x0lamyvmdodgtqce74",
            description = "Keep your pup dry during rainy walks with 100% waterproof exterior fabric, adjustable belly strap, leash access hole, and high-visibility reflective safety stripes.",
            specifications = listOf(
                "Material" to "Polyurethane coated waterproof polyester",
                "Features" to "Leash slit, reflective piping, elastic leg straps",
                "Sizes" to "XS, S, M, L, XL, XXL"
            ),
            variants = listOf("Yellow - Small", "Yellow - Medium", "Yellow - Large", "Red - Medium"),
            isNewArrival = true
        ),
        Product(
            id = "beneera-cat-scratching-tree",
            name = "Beneera Multi-Level Modern Cat Scratching Tree",
            category = "Cat Supplies",
            price = 79.99,
            originalPrice = 99.99,
            rating = 4.9,
            reviewCount = 175,
            imageUrl = "vgmys1suxkug5tvagpg9",
            description = "A stylish multi-level cat tree featuring natural sisal scratching posts, plush condo hideouts, dangling play toys, and top observation perches wrapped in soft faux fur.",
            specifications = listOf(
                "Dimensions" to "24\" L x 20\" W x 48\" H",
                "Material" to "Natural sisal rope, engineered wood, plush fabric",
                "Weight Capacity" to "Supports multiple cats up to 25 lbs total"
            ),
            variants = listOf("Beige", "Slate Gray"),
            isFeatured = true,
            isOnSale = true
        )
    )
}

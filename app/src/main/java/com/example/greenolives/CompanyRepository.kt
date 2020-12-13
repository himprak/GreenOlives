package com.example.greenolives

import android.content.Context
import androidx.core.util.rangeTo
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.example.greenolives.database.CompanyDatabase
import java.lang.IllegalStateException
import java.util.*
import java.util.concurrent.Executors

private const val DATABASE_NAME = "company-database"

class CompanyRepository private constructor(context: Context) {

    private val database : CompanyDatabase = Room.databaseBuilder(
        context.applicationContext,
        CompanyDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val companyDao = database.companyDao()

    private val executor = Executors.newSingleThreadExecutor()

    fun getCompanies(): LiveData<List<Company>> = companyDao.getCompanies()

    fun getCompany(id: UUID): LiveData<Company?> = companyDao.getCompany(id)

    fun updateCompany(company: Company) {
        executor.execute {
            companyDao.updateCompany(company)
        }
    }

    fun addCompany(company: Company) {
        executor.execute {
            companyDao.addCompany(company)
        }
    }

    fun clearCompanies() {
        executor.execute {
            companyDao.clearCompanies()
        }
    }

    companion object {

        private var INSTANCE: CompanyRepository? = null

        fun initialize(context: Context) {
            if(INSTANCE == null) {
                INSTANCE = CompanyRepository(context)
            }

            INSTANCE?.clearCompanies()

            INSTANCE?.addCompany(Company(
                UUID.randomUUID(),
                "Instamojo",
                "\"Full-stack platform for 1+ million MSMEs\"",
                "Payments",
                "Akash Gehani, Harshad Sharma, Sampad Swain",
                Date(2012 - 1900, 1, 1),
                true,
                "Series B",
                4,
                0.0,
                "11-50 empolyees",
                "instamojo",
                "Gunosy Capital, AnyPay, Kalaari Capital and Rashmi Kwatra",
                "$7.75 million",
                "Our mission is to make small and medium businesses, truly enterprising. Businesses use Instamojo to instantly start, sell, manage and grow using our wide range of products & services like payments, free online store, logistics, credit & financing and more across mobile & web. Over 1,000,000 Indian businesses from 29 States and 7 Union Territories with 10+ million customers use Instamojo."
            ))

            INSTANCE?.addCompany(Company(
                UUID.randomUUID(),
                "ixigo.com",
                "\"India's Mobile Travel Marketplace\"",
                "Online Travel & Tourism",
                "Aloke Bajpai, Dharmendra Yashovardhan, Rajnish Kumar",
                Date(2006-1900, 1, 1),
                true,
                "Series B",
                6,
                0.0,
                "101-250 empolyees",
                "ixigo",
                "Sequoia Capital India, Fosun RZ Capital, MicroMaxInformatics",
                "$35.5 million",
                "Ixigo is an intelligent, AI-based travel app that helps you organise, book and track your trips. With ixigo, get to know real-time prices & availability for flights, trains, buses, cabs, hotels and destinations. ixigo is your ‘One Stop Travel Shop’. So what are you waiting for? If you aren’t already among the millions of travellers who have chosen to simplify their lives, then it’s time to come aboard the ixigo experience."
            ))

            INSTANCE?.addCompany(Company(
                UUID.randomUUID(),
                "Unacademy",
                "\"India's largest free learning platform\"",
                "Mobile Education",
                "Gaurav Munjal, Hemesh Singh, Sachin Gupta",
                Date(2015-1900,1,1),
                true,
                "Series D",
                28,
                0.0,
                "51-100 empolyees",
                "unacademy",
                "Gaurav Munjal, Aakrit Vaish, Sequoia Capital",
                "$88.5 million",
                "Classroom education in India has stifled many brilliant minds. With Unacademy, India's largest education platform, we are changing that. In a span of 6 months, over 300,000 students have benefited from over 2,400 online lessons and specialised courses on cracking various competitive examinations, on our platform. We have on board some of the top educators in the country, including Kiran Bedi, India's first woman IPS officer and now the Governor of Pondicherry. With over 2 million views every month, we are touching the lives of people in the remotest corners of the country. Our success stories include thousands of students who have cracked toughest of examinations, improved their ability to speak and write better and increase their knowledge. Our vision is to partner with the brightest minds and have courses on every possible topic in multiple languages so the whole world can benefit from these courses."
            ))

            INSTANCE?.addCompany(Company(
                UUID.randomUUID(),
                "Nykaa.com",
                "\"India's premier online destination for beauty & wellness\"",
                "E-Commerce, Beauty",
                "Falguni Nayar",
                Date(2012-1900,1,1),
                true,
                "Series E",
                11,
                0.0,
                "201-500 empolyees",
                "nykaa",
                "TPG Growth, Sharrp Ventures, Lighthouse Funds",
                "$93.3 million",
                "Since its inception in 2012, Nykaa has quickly emerged as India’s largest omnichannel beauty destination with millions of happy customers across the country. From bringing you your favorite brands and keeping you up-to-date with the latest beauty trends, expert advice and videos, to more than 30 Luxe and On-Trend Stores, an ever growing online community for beauty buffs, and a Beauty Helpline, we go out of our way to give you only the very best. With 1200+, 100% genuine brands, and six warehouses across India that stock lakhs of well curated, well priced products, Nykaa offers a comprehensive selection of makeup, skincare, hair care, fragrances, personal care, luxury and wellness products for women and men."
            ))

            INSTANCE?.addCompany(Company(
                UUID.randomUUID(),
                "Shuttl",
                "\"Bus-aggregating platform solving daily commute problems\"",
                "Mobile Transportation",
                "Amit Singh, Deepanshu Malviya",
                Date(2015-1900,1,1),
                true,
                "Series C",
                20,
                0.0,
                "201-500 empolyees",
                "shuttl",
                "Moving Capital, SPARX Group, Toyotal Tsusho",
                "$111.3 million",
                "Shuttl is the future of public transport. It’s a mobile based minibus service aimed at making your daily commute more convenient. Our vehicles are air-conditioned and operate with high frequency on fixed routes freeing you from the hassles of existing public transport options at a very economical price point."
            ))

            INSTANCE?.addCompany(Company(
                UUID.randomUUID(),
                "Haptik",
                "\"Conversational AI platforms\"",
                "Artificial Intelligence",
                "Aakrit Vaish, Swapan Rajdev",
                Date(2013-1900,1,1),
                true,
                "Series B",
                3,
                0.0,
                "51-200 empolyees",
                "haptik",
                "Times Internet, Vivek Kumar, Kalaari Capital",
                "$12.2 million",
                "We are one of the world's largest Conversational AI companies, having reached over 100 million devices, and processed over 2 billion conversations till date. Established in 2013, Haptik has been at the forefront of the paradigm shift of interaction from clicks to conversations. We have built a robust set of technology and tools that can enable any kind of conversational application. With a 100-member strong team, including some of the finest minds in Artificial Intelligence, Haptik is truly poised to lead the Conversational AI revolution."

            ))

            INSTANCE?.addCompany(Company(
                UUID.randomUUID(),
                "Locus.sh",
                "\"Intelligent Logistics\"",
                "E-Commerce Logistics",
                "Geet Garg, Nishith Rastogi",
                Date(2015-1900,1,1),
                true,
                "Series B",
                19,
                0.0,
                "11-50 empolyees",
                "locus",
                "Blume Ventures, Exfinity Venture Partners, Tiger Global Management",
                "$28.8 million",
                "Locus is the most advanced supply chain decision-making engine helping you reduce costs, and achieve efficiency, consistency & transparency in operations."
            ))

            INSTANCE?.addCompany(Company(
                UUID.randomUUID(),
                "Swiggy",
                "\"Food Delivery 2.0 for India\"",
                "Food and Beverages Logistics",
                "Nandan Reddy, Rahul Jaimini, Sriharsha Majety",
                Date(2014-1900,1,1),
                true,
                "Series H",
                14,
                0.0,
                "1001-5000 empolyees",
                "swiggy",
                "Meituan-Dianping, DST Global, Tencent Holdings",
                "$1.5 billion",
                "Swiggy is the leading food ordering and delivery platform in India. The innovative technology, large and nimble delivery service, and exceptional consumer focus at Swiggy has enabled a host of benefits that includes lightning fast deliveries, live order tracking and no restrictions on order amount, all while having the pleasure of enjoying your favourite meal wherever you'd like it."
            ))

            INSTANCE?.addCompany(Company(
                UUID.randomUUID(),
                "EazyDiner",
                "\"Online Restaurant Reservations\"",
                "Online Reservations",
                "Vir Sanghvi",
                Date(2014-1900,1,1),
                true,
                "Series B",
                8,
                0.0,
                "11-50 empolyees",
                "eazydiner",
                "BEENEXT, Denlow Investment Trust, Saama Capital",
                "$14.6 million",
                "EazyDiner has been created by a team who is extremely passionate about food, wine and all things fine. As a collective group of Chefs and Hoteliers who have worked in some of the best hotels and restaurants around the world, we were always on the lookout for new dining experiences and exciting cuisines. It is this love and passion for eating and exploring that brought us together to create eazydiner.com."
            ))

            INSTANCE?.addCompany(Company(
                UUID.randomUUID(),
                "Craftsvilla.com",
                "\"Fresh Designs Everyday!\"",
                "E-Commerce",
                "Bhavik Jhaveri, Manoj Gupta, Monica Gupta, Sarvajeet Chandra",
                Date(2011-1900,1,1),
                true,
                "Series Unknown",
                5,
                0.0,
                "101-250 empolyees",
                "craftsvilla",
                "Supera, Lightspeed Venture Partners, Sequoia Capital India",
                "$58.8 million",
                "Craftsvilla.com is a marketplace to \"Discover Unique Indian Products\" including Handmade, Vintage, Ethnic, Organic and Natural products from India. India is a beautiful assortment of diversity reflected in our Clothing, Food, Lifestyle, Language, Music, Books etc. This diversity is so rich and diverse that an attempt to capture it on a single platform was never made. Craftsvilla.com is that sincere attempt by bunch of young insane guys and gals who think this is possible now with the Internet."
            ))

            INSTANCE?.addCompany(Company(
                UUID.randomUUID(),
                "Fynd",
                "\"Fresh Fashion, Straight From Brand Stores\"",
                "Fashion E-Commerce, Artificial Intelligence",
                "Farooq Adam, Harsh Shah, Sreeraman Mohan Girija",
                Date(2012, 1, 1),
                true,
                "Series C",
                19,
                0.0,
                "51-200 empolyees",
                "fynd",
                "Google, IIFL, Venture Catalysts",
                "$7.3 million",
                "Fynd is India's Largest Fashion O2O company with real-time inventory access to over 8.5k+ stores. Being a unique fashion e-commerce portal, it brings the latest in-store fashion online. The company channelizes its combined outreach to offer the best brands and fashion along with superior customer services to its ever-growing clientele. Technology plays a major part in the company's growth and APIs are the backbone of this business."
            ))

            INSTANCE?.addCompany(Company(
                UUID.randomUUID(),
                "smallcase",
                "\"Changing how India invests\"",
                "Personal Finance, Financial Technology,",
                "Anugrah Shrivastava, Rohan Gupta, Vasanth Kamath",
                Date(2015-1900,1,1),
                true,
                "Series A",
                7,
                0.0,
                "51-200 empolyees",
                "smallcase",
                "Sequoia Capital India, Blume Ventures, WEH Ventures",
                "$8 million",
                "Helping individuals invest in low-cost, transparent products. Enabling professionals to share portfolio research. Providing infrastructure to enable portfolio execution for stocks/ETFs"
            ))

            INSTANCE?.addCompany(Company(
                UUID.randomUUID(),
                "DocTalk",
                "\"Revolutionizing patient care\"",
                "Healthcare",
                "Akshat Goenka, Vamsee Chamakura",
                Date(2016-1900,1,1),
                true,
                "Seed",
                15,
                0.0,
                "1-10 empolyees",
                "doctalk",
                "Paul Buchheit, AltalR Capital, Y Combinator",
                "$5 million",
                "DocTalk Solutions, develops and offers a mobile application that enables patients to communicate with their doctors. Users can chat with their doctors, obtain prescriptions and share new reports with their doctors."

            ))

            INSTANCE?.addCompany(Company(
                UUID.randomUUID(),
                "Skylark Drones",
                "\"Delivering drone solutions that matter\"",
                "Infrastructure Monitoring, Agriculture",
                "Mrinal Pai, Mughilan Thiru Ramasamy",
                Date(2014-1900,1,1),
                true,
                "Series Unknown",
                0,
                0.0,
                "11-50 empolyees",
                "skylark",
                "Unknown",
                "Unknown",
                "There is one principal reason that drives how we spend our time and energy and that is our belief that drone solutions will change the way we live for the better. Drones shed light about our world from a unique perspective and engineering that perspective into insight and impact is what we do. Much of what we build here is the engine that will drive the future of drone-powered solutions. To believe in what drones can do and have the persistence to realise their potential is the common thread that binds us with the ones who choose to trust us with their businesses, data and careers. We bring a set of principles and values to the relationship that is best expressed by starting with the right question."
            ))

            INSTANCE?.addCompany(Company(
                UUID.randomUUID(),
                "Postman",
                "\"Collaboration platform for API development\"",
                "Web Development, Cloud Infrastructure",
                "Abhijit Kane, Abhinav Asthana, Ankit Sobti",
                Date(2014-1900,1,1),
                true,
                "Series B",
                2,
                0.0,
                "51-200 empolyees",
                "postman",
                "Nexus Venture Partners, CRV",
                "$58 million",
                "Postman is a collaboration platform for API development. Postman's features simplify each step of building an API and streamline collaboration so you can create better APIs—faster."
            ))

            INSTANCE?.addCompany(Company(
                UUID.randomUUID(),
                "Testbook.com",
                "\"Exam Preparation Simplified\"",
                "K-12 Education",
                "Abhishek Sagar, Ashutosh Kumar, Manoj Munna, Narendra Agrawal, Yadvendar Champawat",
                Date(2013,1,1),
                true,
                "Series A",
                5,
                0.0,
                "51-200 empolyees",
                "testbook",
                "Matrix Partners India, Utsav Somani, LetsVenture",
                "$4.3 million",
                "Testbook is an affordable platform for faster and efficient exam preparation. Users can learn new concepts, attempt numerous mocktests to compare their preparation level with thousands of fellow aspirants. We provide users with relevant analytics on his performance in the mocktests to pinpoint their weak areas of preparation."
            ))

            INSTANCE?.addCompany(Company(
                UUID.randomUUID(),
                "Nanonets",
                "\"Machine Learning as a Service for Developers\"",
                "Machine Learning, Big Data",
                "Prathamesh Juvatkar, Sarthak Jain",
                Date(2017-1900,1,1),
                true,
                "Seed",
                8,
                0.0,
                "11-50 empolyees",
                "nanonets",
                "SV Angel, Soma Capital, Avalon Ventures",
                "$1.5  million",
                "To make Machine Learning as ubiquitous as databases. There are no db companies because of Oracle. All companies will be ML powered through us"
            ))

            INSTANCE?.addCompany(Company(
                UUID.randomUUID(),
                "LogiNext",
                "\"Organized Logistics and Field Service Management\"",
                "Logistics Software",
                "Dhruvil Sanghvi, Manisha Raisinghani",
                Date(2014-1900,1,1),
                true,
                "Series A",
                3,
                0.0,
                "51-200 empolyees",
                "loginext",
                "Paytm, Nitin Singhal, Gennext Innovation Hub",
                "$10.6 million",
                "Welcome to the world of organized logistics and field service management. Ever imagined all your field services like vehicles, shipments, carriers and even your on-field workforce being tracked and optimized in real-time on a single map interface? And what if you could plan & manage their dispatch schedule, delivery routes, and capacity in the most cost-optimized way?"
            ))

            INSTANCE?.addCompany(Company(
                UUID.randomUUID(),
                "Kisan Network",
                "\"Online Platform for Indian Agriculture\"",
                "Agriculture, Mobile Commerce",
                "Aditya Agarwalla, Sanjay K Agarwalla",
                Date(2016-1900, 1, 1),
                true,
                "Seed",
                1,
                0.0,
                "51-200 empolyees",
                "kisan",
                "Y Combinator",
                "$120 thousand",
                "Since as far back as one can remember, information and commodity flow in rural India have been dominated by players who have thrived on the opaqueness, inconsistency and fragmentation of the ecosystem. Technology, while making rapid strides in the everyday life of an urban dweller, has had little to no impact on the rural economy. However, at Kisan Network, we believe that with millions of rural internet users coming online for the first time on mobile, it is time they reap its benefits. We are building this future with our fully integrated and tech enabled supply chain that enables farmers PAN India to earn more by selling their produce directly to businesses."
            ))

            INSTANCE?.addCompany(Company(
                UUID.randomUUID(),
                "Niki",
                "\"Your local agent helping you access services online\"",
                "Natural Language Processing",
                "Keshav Prawasi, Nitin Babel, Sachin Jaiswal, Shishir Modi",
                Date(2015-1900,1,1),
                true,
                "Series A",
                14,
                0.0,
                "51-200 empolyees",
                "niki",
                "Unilazer Ventures, Haresh Chawla, Ratan Tata",
                "$6.3 million",
                "Niki is on a mission to turn India’a 500 million new Internet users into transacting consumers. It has built Internet commerce in the style that’s most natural to these users: whereby a user can replicate talking to a neighbourhood human agent in their own language to access hundreds of services. Niki’s proprietary deep technology mirrors and enhances the offline experience leveraging machine learning and Natural Language Processing."
            ))

            INSTANCE?.addCompany(Company(
                UUID.randomUUID(),
                "HyperTrack",
                "\"Build applications that track the movement of your business\"",
                "Location Based Services",
                "Abhishek Poddar, Kashyap Deorah, Tapan Pandita",
                Date(2015-1900,1,1),
                true,
                "Series A",
                11,
                0.0,
                "11-50 employees",
                "hypertrack",
                "Nexus Venture Partners, Founders Fund, Vy Capital",
                "$8.5 million",
                "HyperTrack is a managed service for live location. Developers use HyperTrack to build applications that track the movement of their business. This makes assets more productive and delights customers with great product experiences. Our users include entrepreneurs in a cafe, high growth startups, public companies launching new products, and enterprises going through digital transformation, from all inhabited continents. Apps built with HyperTrack include ridesharing, workforce automation, gig work, on-demand delivery, logistics, marketplace aggregators, package delivery, trucking, fleet management and more."
            ))

            INSTANCE?.addCompany(Company(
                UUID.randomUUID(),
                "The Moms Co.",
                "\"Helping Moms make Safe, Natural, Effective choices\"",
                "Consumer Internet, FMCG",
                "Malika Datt Sadani, Mohit Sadaani",
                Date(2016-1900,1,1),
                true,
                "Series B",
                2,
                0.0,
                "11-50 employees",
                "moms",
                "DSG Consumer Partners, Saama Capital",
                "$6 million",
                "At The Moms Co. our products are made with love and without compromise. We have brought in experts from across the world to help us create the safest natural formulations that are certified toxin free. With Mother Nature making her presence felt very strongly, everything we create retains the good and rejects the bad to give you a product that is as pure as mother’s love."
            ))

            INSTANCE?.addCompany(Company(
                UUID.randomUUID(),
                "MobiKwik",
                "\"Digital Credit for the Masses of India\"",
                "Payments, Lending",
                "Bipin Singh, Upasana Taku",
                Date(2009-1900,1,1),
                true,
                "Series Unknown",
                14,
                0.0,
                "201-500 empolyees",
                "mobikwik",
                "NDTV Limited, Trifecta Capital Advisors, Cisco",
                "$118.4 million",
                "MobiKwik is India’s largest issuer-independent digital financial services platform, leveraging a sophisticated product and merchant acquisition capabilities. It is the undisputed No.2 player in the mobile wallet space in India and amongst the top 3 players in the payment gateway industry in the country. It has a network of over 3 million direct merchants, 140+ billers and 107 million-plus users. It records over 1 million transactions per day."
            ))

            INSTANCE?.addCompany(Company(
                UUID.randomUUID(),
                "Junglee Games",
                "\"Skill Games!\"",
                "Mobile Games",
                "Ankush Gera",
                Date(2012-1900,1,1),
                true,
                "Seed",
                1,
                0.0,
                "201-500 empolyees",
                "junglee",
                "Velo Partners",
                "$3.5 million",
                "As a pioneer in the Indian gaming space with over 25 million users, Junglee Games develops cutting-edge gaming technology and customized licensing solutions for desktop and mobile platforms. We are the fastest-growing skill games company in South East Asia and were the first to launch skill games for cash prizes. Some of our best-known games include Junglee Rummy, Eatme.io, Junglee Teen Patti and Howzat."
            ))
        }

        fun get(): CompanyRepository {
            return INSTANCE ?:
                    throw IllegalStateException("CompanyRepository must be initialized")
        }
    }
}
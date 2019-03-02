package com.app.doctorwork.Common;

/**
 * Created by abhisheksingh on 11/18/17.
 */

public class AppConstants {


    //preference keys
    public static final String PREFERENCES_USER = "USER";
    public static final String PREFERENCES_USER_EXTRA_DATA = "USEREXTRA";
    public static final String PREFERENCES_USER_NAME="NAMEOFUSER";
    public static final String PREFERENCES_USER_SHOP_NAME="NAMEOFSHOP";
    public static final String PREFRENCES_MOBILE = "MOBILE";
    public static final String PREFRENCES_EMAIL = "EMAIL";
    public static final String PREFERENCES_IMAGE_URL = "USERIMGURL";
    public static final String PREFERENCES_SESSION_ID = "SESSIONID";
    public static final String PREFERENCES_USER_ID = "USERID";
    public static final String PREFERENCES_USER_GSTN_NUMBER = "GSTNUMBER";
    public static final String PREFERENCES_TALLY_KEY = "TALLYKEY";
    public static final String PREFERENCES_USER_STATE = "USERSTATE";
    public static final String PREFERENCES_USER_DISTRICT = "USERDISTRICT";
    public static final String PREFERENCES_USER_SUB_DISTRICT = "USERSUBDISTRICT";
    public static final String PREFERENCES_USER_VILLAGE = "USERVILLAGE";
    public static final String PREFERENCES_USER_PINCODE = "USERPINCODE";
    public static final String PREFERENCES_USER_LOGGED_IN = "LOGGED_IN";
    public static final String PREFERENCES_USER_TOKEN = "gcmId";
    public static final String PREFERENCES_USER_ADDR = "USERADDRESS";
    public static final String PREFERENCES_STOCK_FLAG = "STOCKFLAG";
    public static final String PREFERENCES_CREDIT_FLAG = "CREDTIFLAG";
    public static final String PREFERENCES_LOCATION_LAT = "LOC_LAT";
    public static final String PREFERENCES_LOCATION_LONG = "LOC_LONG";
    public static final String PREFERENCES_MAINTENCE_FLAG = "MAINTENECE_FLAG";
    public static final String PREFERENCES_MAJOR_UPDATE = "MAJOR_UPDATE";
    public static final String PREFERENCES_INFORMATION_SERVICE_FLAG = "INFORMATION_SERVICE_FLAG";
    public static final String PREFERENCES_versionCode = "versionCode";
    public static final String PREFERENCES_APP_LINK = "AppLink";
    public static final String PREFERENCES_IS_TALLY_INTEGERATED = "isTallyIntegrated";
    public static final String PREFERENCES_IS_DISTRIBUTOR_INTEGERATED = "isDistributorLinked";
    public static final String PREFRENCES_NUM_CROPS = "NUMCROPS";
    public static final String latest_video_date="latestVideoDate";
    public static final String video_popup_shown="ShareVideosflag";


    //baseurl
    public static final String BASE_URL_MAIN = "http://ec2-13-127-214-8.ap-south-1.compute.amazonaws.com/";




    public static final String YES_ACTION = "YES_ACTION";
    public static final String NO_ACTION = "NO_ACTION";


    //Flags
    public static final String FLAG_STOCK = "LOCATION_MANUAL";
    public static final String FLAG_CREDIT = "LOCATION_MANUAL";


    public static final int PERMISSION_REQUEST_GRANT = 1;


    //values
    public static final String RML_USER_KEY = "93edd0d9-056e-44c0-a881-c050da0d5b6d";
    public static final String LANGUAGE_ID = "EN";
    public static final String STATE_ID = "MH";

    //Database
    public static final String DB_NAME = "kisanx.db";
    public static final String DB_KEY_USER_MYPOOLIN_USER_IMAGE_URL = "imageUrl";
    public static final int DATABASE_VERSION = 4;
    public static final String TABLE_CONTACTS_NAME = "kisanx_contacts";
    public static final String TABLE_KISANX_OFFER_ALERT_NAME = "alerts";
    public static final String TABLE_KISANX_GROUPS_NAME = "kisanx_groups";
    public static final String TABLE_KISANX_USERS_GROUPS_NAME = "mp_contacts_groups";
    public static final String DB_KEY_ID = "_id";
    public static final String DB_KEY_EMAIL = "user_email";
    public static final String DB_KEY_USER_DISPLAY_NAME = "user_display_name";
    public static final String DB_KEY_IS_DELETED = "deleted";
    public static final String DB_KEY_USER_PHONE = "user_phone";
    public static final String DB_KEY_USER_PHONE_COUNTRY_CODE = "user_country_code";
    public static final String DB_KEY_USER_IS_MYPOOLIN_USER = "is_mypoolin_user";
    public static final String DB_KEY_USER_MYPOOLIN_USER_ID = "mypoolin_user_id";
    public static final String DB_KEY_USER_MYPOOLIN_USER_DISPLAY_NAME = "mypoolin_user_display_name";
    public static final String DB_KEY_CREATED = "created_on";
    public static final String DB_KEY_LAST_UPDATED = "updated_on";
    public static final String DB_KEY_USER_MYPOOLIN_USER_FREQUENCY_COUNT = "frequency_count";
    public static final String DB_KEY_GROUP_DISPLAY_NAME = "group_name";
    public static final String DB_KEY_POOL_ID = "pool_id";
    public static final String DB_KEY_GROUP_MEMBER_COUNT = "member_count";
    public static final String DB_KEY_GROUP_USAGE_COUNT = "usage_count";
    public static final String DB_KEY_GROUP_ID = "group_id";
    public static final String DB_KEY_CONTACTS_ID = "contacts_id";
    public static final String DB_KEY_GROUP_IS_ORGANIZER = "is_organizer";
    public static final String DB_KEY_TITLE = "title";
    public static final String DB_KEY_IMAGE = "image";
    public static final String DB_KEY_MESSAGE = "message";
    public static final String DB_KEY_POOL_TYPE = "pooltype";
    public static final String DB_KEY_THEME = "theme";
    public static final String DB_KEY_IMAGE_TYPE = "imagetype";
    public static final String DB_KEY_EXPIRY = "expiry";
    public static final String DB_KEY_IMAGE_URL = "imageurl";
    public static final String DB_KEY_TYPE = "type";
    public static final String DB_KEY_FEED_MOBILE = "feedMobile";
    public static final String DB_KEY_DEEP_LINK = "deeplink";
    public static final String DB_KEY_P2P_TRANSFER_ID = "p2p_id";
    public static final String DB_KEY_GROUP_HASH = "group_hash";

    public static final String DB_KEY_IS_FAVOURITE = "is_favourite";
    public static final String DB_KEY_ON_MYPOOLIN = "on_mypoolin";
    public static final String DB_KEY_USER_MYPOOLIN_NAME = "mypoolin_display_name";
    public static final String DB_KEY_USER_CUSTOM_CONTACT_LABEL = "contact_label";
    public static final String DB_KEY_USER_DEFAULT_VIRTUAL_ADDRESS = "vpa";
    public static final String d = "D";
    public static final String DB_KEY_CONTACT_SYNCED = "is_synced";
    public static final String p = "5";
    public static final String DB_KEY_USER_MYPOOLIN_USER_FREQUENCY_COUNT_P2P = "frequency_count_p2p";



    //http://api.kisanx.com/api/ticket-enquiries
    //Youtube
    public static final String DEVELOPER_KEY = "AIzaSyCNYKLf-iag6FLBsxikZzv0-Dg7BEgDubQ";

    // YouTube video id
    public static final String YOUTUBE_VIDEO_CODE = "RavNWfdU8I0";
    //public static final String YOUTUBE_VIDEO_CODE = "v7K4vGYL9zI";
    public static final String[] youtubeVideosList = new String[]{"RavNWfdU8I0", "RavNWfdU8I0", "RavNWfdU8I0"};

    // Listview Data
    public static final String medicineList[] = {
            "Abelcet",
            "Amikacin",
            "Atomoxetine HCl",
            "Benefix",
            "Bexarotene",
            "Cabergoline",
            "Capozide",
            "Dactinomycin",
            "Daraprim",
            "Daypro",
            "Efalizumab",
            "Elidel",
            "Famotidine",
            "Fentora",
            "Gadoversetamide",
            "Gammagard",
            "Halobetasol Propionate",
            "Halothane",
            "Idamycin",
            "Idarubicin",
            "jantoven",
            "Kapidex",
            "Kerlone",
            "Lactulose",
            "Leflunomide",
            "Magnevist",
            "Macugen",
            "Naftifine",
            "Naltrexone",
            "Olanzapine",
            "Omnicef",
            "Palonosetron",
            "Panhematin",
            "Quinidine",
            "Questran",
            "Raltegravir",
            "Ranolazine",
            "Salsalate",
            "Saphris",
            "Tadalafil",
            "Tapazole",
            "Univasc",
            "Uroxatral",
            "Valdecoxib",
            "Vaprisol",
            "Westcort",
            "Welchol",
            "Xenical",
            "Xifaxan",
            "Yasmin",
            "Yohimbine",
            "Zalcitabine",
            "Zantac"
    };

    public static final String mobile[] = {
            "9745734582",
            "8123757599",
            "9087344387",
            "8145327645",
            "9075437654",
            "8167584572",
            "9187456934",
            "8134787445",
            "7177734488",
            "9045873239",
            "7048904472",
            "9845349820"
    };

    public static final String dob[] = {
            "21 Jun 1975",
            "08 Nov 1972",
            "24 Oct 1977",
            "25 Feb 1970",
            "12 Dec 1965",
            "13 Nov 1968",
            "19 Feb 1977",
            "20 Aug 1975",
            "17 Jun 1980",
            "18 Jul 1985",
            "19 Mar 1972",
            "27 Apr 1970"
    };

    public static final String village[] = {
            "Isarpur",
            "Adhur",
            "Abela",
            "Aakera",
            "Archaung",
            "kalthur",
            "Adibetthalli",
            "kalthur",
            "Dabipara",
            "Gadaul Bhartiya",
            "Lachonden",
            "Ajasora"

    };

    public static final String creditsDue[] = {
            "3500, 45 Days",
            "1250, 15 Days",
            "1200, 46 Days",
            "2500, 25 Days",
            "3500, 40 Days",
            "8750, 30 Days",
            "8000, 30 Days",
            "1250, 6 Days",
            "4500, 36 Days",
            "5000, 32 Days",
            "3750, 15 Days",
            "7800, 28 Days"
    };

    public static final String landArea[] = {
            "Solapur south, Solapur,Maharastra ",
            "Tirurangadi,Malappuram,Kerala",
            "NiloKheri,Karnal,Haryana",
            "Rewari,Rewari",
            "Sangau,Saiha",
            "Padhar,Mandi,Himachal Pradesh",
            "Udipi,Udipi,Karnataka",
            "Tirumakudal Narsipur,Mysore,Karnataka",
            "Pachhad,Sirmaur,Himachal Pradesh",
            "Konta,Dantewada,Chhattisgarh",
            "Sangla,Kinnaur,Himachal Pradesh",
            "Peint, Nashik, Maharasta"
    };

    public static final String stockItems[] = {
            "Cotton ",
            "Wheat",
            "Maize",
            "Oat",
            "Bitter Gourd",
            "Moong Dal",
            "Apple",
            "Rice",
            "Jute",
            "Sugarcane",
            "Tea",
            "Coffee"
    };

    public static final String stockPrice[] = {
            "3000",
            "2500",
            "2000",
            "3200",
            "5500",
            "5750",
            "6200",
            "3000",
            "4200",
            "800",
            "2000",
            "2890"
    };

    public static final String stockQuantity[] = {
            "300",
            "400",
            "1000",
            "700",
            "40",
            "180",
            "500",
            "600",
            "350",
            "700",
            "590",
            "875"
    };

    public static final String creditPendingDays[] = {
            "45",
            "40",
            "32",
            "16",
            "28",
            "6",
            "54",
            "23",
            "53",
            "70",
            "43",
            "72"
    };

    public static final String time[] = {
            "03:00 PM",
            "09:00 AM",
            "02:45 PM",
            "06:00 AM",
            "05:45 PM",
            "06:12 AM",
            "05:32 PM",
            "03:23 PM",
            "02:30 PM",
            "07:00 AM",
            "04:00 PM",
            "06:34 AM"
    };


    public static final String Solutionservices[] =
                {"Greenhouse",
                "Borewell",
                "Nearby nurseries",
                "Hydroponic fodder",
                "Equipment rental",
                "Urea deep placement",
                "Nearby Cold Storages and Warehouses",
                "Packaging", "Buyers",
                "Logistics",
                "Earthmoving",
                "Organic Fertilizer"
    };

    public static final String audio[] = {
            "https://gaana.com/song/main-hoon-saath-tere",
            "https://gaana.com/song/phir-bhi-tumko-chaahunga",
            "https://gaana.com/song/main-tera-boyfriend",
            "https://gaana.com/song/nashe-si-chadh-gayi",
            "https://gaana.com/song/hawayein-1",
            "https://gaana.com/song/zaalima-3",
            "https://gaana.com/song/galti-se-mistake",
            "https://gaana.com/song/ik-vaari-aa",
            "https://gaana.com/song/raabta-title-track",
            "https://gaana.com/song/ae-dil-hai-mushkil",
            "https://gaana.com/song/roke-na-ruke-naina",
            "https://gaana.com/song/naina-45"
    };



    public static final String SoilTesting[]={
            "Soil Test only",
            "Service For low value crops( Rice, Wheat, Maize, Soybean ...)",
            "Service For medium value crops(Vegetables)",
            "Service For high value crops(Fruits, Spices)"};

    public static final String SoilTestingPrice []={
            "1500 INR/Sample",
            "2000 INR/Sample/Season",
            "3000 INR/Sample/Season",
            "5000 INR/Sample/Season"};
    public static final String PREFERENCES_USER_LANGUAGE = "user-language";
    public static final String KEY_PREFERENCE_FILTER_APPLIED ="filter" ;

    public static final String[] stocks = ("Aaatank 1 ltr,Aaatank  250 ml ," +
            "Aaatank 500 ml ,Acricio 100 ml,Acrobat 1 kg ,Acrobat 200 gm," +
            "Actara 1 kg,Actara 100 gm,Actara 250 gm,Actara 5 kg,Actara 500 gm," +
            "Admire 150 gm,Admire 2 gm,Admire 30 gm,Admire 300 gm,Admire 75 gm," +
            "Agroneem 1 % 1 ltr ,Agroneem 1 % 250 mi,Agroneem 1 % 500 mi," +
            "Ajay Antistress 1 ltr ,Ajay Antistress 5 ltr ," +
            "Ajay Antistress 500 ml,Ajay Azo sf 1 ltr ,Ajay Azo sf 10 ltr ," +
            "Ajay Azo sf 5 ltr ,Ajay Potash Sf 1 ltr ,Ajay Potash Sf 5 ltr ," +
            "Ajay Sulf 1 ltr,Ajay Sulf 20 ltr,Ajay Sulf 5 ltr,Ajay Sulf 500 ml," +
            "Alanto 1 ltr ,Alanto 100 ml,Alanto 250 ml,Alanto 500 ml,Alcure 1 ltr ," +
            "Alcure 5 ltr ,Alcure 500 ml,Aliette 1 kg ,Aliette 100 gm,Aliette 250 gm," +
            "Aliette 500 gm,Alika 200 ml,Alika 500 ml,Alika 80 ml,Amistar 1 ltr ," +
            "Amistar 200 ml,Amistar 50 ml,Amistar 500 ml,Amistar Top -200 ml," +
            "Amistar Top -500 ml,Ampligo 200 ml,Ampligo 80 ml,Antitrase 1 ltr ," +
            "Antitrase 5 ltr ,Antracol 1 kg,Antracol 250 gm,Antracol 500 gm,Apple 500 ml ," +
            "Asataf 1 kg,Asataf 250 gm,Asataf 500 gm,Atrataf 500 gm,Autor 1 ltr," +
            "Autor 5 ltr,Autor 500 ml,Bacterisan 1 kg,Bacterisan 100 gm,Bacterisan 250 gm," +
            "Bacterisan 500 gm,Bactermicyne 100 gm,Bactermicyne 25 gm,Beam 100 gm ," +
            "Beam 250 gm ,Belt Expert 100 ml,Belt Expert 250 ml,Belt Expert 50 ml," +
            "Bengard 500 gm,Biolexin 1 ltr ,Biolexin 5 ltr ,Biolexin 500 ml,Biozyme 1 ltr," +
            "Biozyme 250 ml,Biozyme 5 ltr,Biozyme 500 ml,Blitox 500 gm,Blue Copper 10 Kg," +
            "Blue Copper 500 gm,Blue Magic  1 ltr ,Blue Magic  5 ltr ,Blue Magic 250 ml," +
            "Blue Magic 500 ml,Bordex  (L) 1 ltr ,Bordex  (L) 5 ltr ,Bordex  (L) 500 ml ," +
            "Bordex (p) 400  gm ,Bordex 800 gm (p) ,Borocrop 1 kg,Borocrop 250 gm," +
            "Borocrop 5 kg,Borocrop 500 gm,Brassofit 1 ltr ,Brassofit 100 ml,Brassofit 250 ml," +
            "Brassofit 500 ml,Buddi 1 kg,Buddi 1 kg ,Buddi 250 gm ,Buddi 500 gm,Buddi 500 gm ," +
            "Cabfert 250 gm ,Cabfert 500 gm ,Cabritop 3 kg,Cabritop 300 gm,Cabritop 600 gm," +
            "Calcifert 1 kg,Calcifert 250 gm,Calcifert 500 gm,Calcium edta 500 gm,Caldan 100 gm," +
            "Caldan 250 gm,Caldan 500 gm,Canstar 1 ltr ,Canstar 5 ltr ,Capcadis,Captaf 500 gm," +
            "Colour brix  1 ltr ,Colour brix 500 ml ,Combifert 1 kg ,Combifert 100 gm ," +
            "Combifert 250 gm ,Combifert 500 gm ,Combifert liq  1 ltr ,Combifert liq  10 ltr ," +
            "Combifert liq  20 ltr ,Combifert liq  5 ltr ,Combifert liq 500 ml,CombiX super  1 ltr ," +
            "CombiX super 500 ml,Confidor 1 ltr,Confidor 100 ml,Confidor 100 ml,Confidor 250 ml," +
            "Confidor 250 ml,Confidor 50 ml,Confidor 50 ml,Confidor 500 ml,Confidor 500 ml," +
            "Conica 250 gm,Conica 500 gm,Contaf  5 ltr ,Contaf 1 ltr ,Contaf 250 ml,Contaf 500 ml," +
            "Coragen 10 ml,Coragen 30 ml,Coragen 60 ml,Cover Liq 30 ml,Cover Liq 60 ml," +
            "Cropplus 1 ltr ,Cropplus 1 ltr ,Cuman 1 Ltr,Cuman 10 Ltr,Cuman 5 Ltr," +
            "Cuman 500 ml,Curacran 1 ltr ,Curacran 250 ml,Curacran 5 ltr ,Curacran 500 ml," +
            "Cursor 100 ml,Cymbush 1 ltr,Cymbush 100 ml,Cymbush 250 ml,Cymbush 500 ml," +
            "Decis 11 %  250 ml,Decis 11 % 1 ltr ,Decis 11 % 100 ml,Decis 2.8 %  1 ltr," +
            "Decis 2.8 %  100 ml,Decis 2.8 %  250 ml,Decis 2.8 %  500 ml,Delegate 100 ml," +
            "Delegate 180 ml,Dentasu 100 gm,Dentasu 50  gm,Dentasu 6 gm,Dhanuka - M45 250 gm," +
            "Dhanuka -M 45-1 kg,Dhanuka -M 45-500 gm,Dhanusaan 1 ltr,Dhanusaan 250 ml," +
            "Dhanusaan 500 ml,Dhanzyme 1 ltr,Dhanzyme 250 ml,Dhanzyme 500 ml,Dipel 1 ltr," +
            "Dipel 500 ltr,Dow M 45 -500 gm,Dow M 45 1 kg ,Dow M 45 250 gm,Downycide 1 ltr ," +
            "Downycide 250 ml,Downycide 500 ml,Dursban 1 ltr ,Dursban 20 ltr ,Dursban 250 ml," +
            "Dursban 5 ltr ,Dursban 500 ml,Ecocide 1 ltr ,Ecocide 250 ml,Ecocide 5 ltr ," +
            "Ecocide 500 ml,Ecoda 1 ltr ,Ecoda 250 ml,Ecoda 500 ml,Ekalux  500 ml," +
            "Ekalux 1 ltr ,Ekalux 250 ml,Ekalux 4 ltr ,Ergon 1 ltr ,Ergon 250 ml ,Ergon 500 ml," +
            "Ethrel 1 ltr,Ethrel 100 ml,Ethrel 500 ml,Excess 1 ltr ,Excess 250 ml,Excess 5 ltr ," +
            "Excess 500ml,Fame 10 ml ,Fame 100 ml ,Fame 50 ml ,Fero Fert 1 kg ,Fero Fert 250 gm ," +
            "Fero Fert 500 gm ,Flora 1 kg,Flora 100 gm,Flora 250 gm,Flora 500 gm,Flux 50 % 500 gm," +
            "Folicur 1 ltr ,Folicur 100 ml,Folicur 250 ml,Folicur 500 ml,Folio Gold  500 ml," +
            "Folio Gold 1 ltr ,Folio Gold 250 ml,Foost 250 gm,Foost 500 gm,Fungi g-10 kg ," +
            "Fungi g-8 kg ,Funginil 1 kg,Funginil 250 gm,Funginil 500 gm,Gaucho 50 ml,Glydon 1 ltr ," +
            "Glydon 5 ltr ,Goal 100 ml,Goal 250 ml,Goal 500 ml,Gold pick 250 gm,Gramoxone 1 ltr ," +
            "Gramoxone 5 ltr ,Green Miracle 5 ltr,Growthstim 1 ltr ,Growthstim 100 ml," +
            "Growthstim 250 ml,Growthstim 50 ml,Growthstim 500 ml,Haru 1 ltr ,Haru 500 ," +
            "Hi-Dice Super 250 gm,Hi-Dice Super 500 gm,Hoshi 250 ml,Hoshi 500 ml,Humas 1 ltr ," +
            "Humas 5 ltr ,Humas 500 ml ,Humi G 10 kg ,Humigranual 40 kg ,Humigranual 5 kg ," +
            "Icon 62.5 gm,Indofil Z-78 - 1 kg,Indofil Z-78 - 500 gm,Intrepid 100 ml," +
            "Intrepid 300 ml,Isabion 1 ltr ,Isabion 250 ml,Isabion 5 ltr ,Isabion 500 ml,Karate 1 ltr ," +
            "Karate 100 ml,Karate 250 ml,Karate 5 ltr ,Karate 500 ml,Karathin 100 ml,Karathin 250 ml," +
            "Karathin 500 ml,Kasu-B  1 ltr,Kasu-B 250 ml,Kasu-B 500 ml,Kavach 1 kg,Kavach 100 gm ," +
            "Kavach 250 gm,Kemistin 1 kg,Kemistin 100 gm,Kemistin 250 gm,Kemistin 500 gm,Kitazin 1 kg," +
            "Kitazin 250 gm ,Kitazin 500 gm ,Kito Star 1 ltr ,Kito Star 500 ml,Kocied 1 kg,Kocied 500 gm," +
            "Larvacide 1 ltr,Larvacide 100 ml,Larvacide 250 ml,Larvacide 500 ml,Larvin 100 ml,Larvin 250 ml," +
            "Larvin 500 ml,Laudis 115 ml,Laudis 57.5 ml,Leaf Cop 1 ltr,Leaf Cop 250 ml,Leaf Cop 500 ml," +
            "Lesenta 100 gm,Lesenta 40 gm,Libra 1 ltr ,Libra 100 ml,Libra 250 ml,Libra 500 ml," +
            "Librel tmx 1 kg,Librel tmx 250 gm,Librel zinc 500 gm,Lihocin 1 ltr ,Lihocin 100 ml," +
            "Lihocin 250 ml,Lihocin 5 ltr ,Lihocin 500 ml,Luna Experience 1 ltr ,Luna Experience 100 ml," +
            "Luna Experience 250 ml,Magni fert 250 gm,Magni fert 500 gm,Magnifert 1 kg,Manik 100 gm," +
            "Manik 20 gm,Manik 250 gm,Manik 50 gm,Maquera 1 ltr,Maquera 100 ml,Maquera 250 ml,Maquera 5 ltr," +
            "Maquera 500 ml,Marker 1 ltr ,Marker 100 ml ,Marker 250 ml,Marker 500 ml,Matador 1 ltr ," +
            "Matador 250 ml,Matador 500 ml,Maxyld 1 ltr,Maxyld 250 ml,Maxyld 500 ml ,Melody duo 400 gm," +
            "Melody duo 800 gm,Meothrin 1 ltr ,Meothrin 250 ml,Meothrin 500 ml,Merion 80 ml,Metri 100 gm," +
            "Micoplus 1 ltr ,Micoplus 5 ltr ,Microkombi 1 ltr ,Microkombi 20 ltr ,Microkombi 5 ltr ," +
            "Microkombi gr chileted 100 gm,Microkombi gr chileted 200 gm,Microkombi gr chileted 500 gm," +
            "Mida 1 litre ," + "Mida 100 ml,Mida 250 ml,Mida 50 ml,Mida 500 ml,Mitlar 1 ltr ,Mitlar 250 ml ," +
            "Mitlar 500 ml," + "Monokem 1 ltr,Monokem 100 ml,Monokem 250 ml,Monokem 5 ltr,Monokem 500 ml," +
            "Morter 100 gm,Morter 250 gm,Movento 100 ml,Movento 250 ml,Namadart 1 ltr ,Namadart 5 ltr ," +
            "Nativo 100 gm,Nativo 250 gm,Nativo 50 gm,Nativo 500 gm,Neemicide 1 ltr,Neemicide 250 ml,Neemicide 5 ltr ,Neemicide 500 ml,Nemato San 1 kg ,Nemato San 250 gm ,Nemato San 500 gm ,Nemato-G 10 kg,Nemato-G 8 kg,Neutraspread 1 ltr,Neutraspread 100 ml,Neutraspread 250 ml,Neutraspread 5 ltr,Neutraspread 500 ml,Nomite plus 1 ltr ,Nomite plus 250 ml ,Nomite plus 500 ml ,Nukem 1 ltr,Nukem 100 ml ,Nukem 250 ml ,Nukem 5 ltr,Nukem 500 ml ,Oberon 1 ltr ,Oberon 100 ml,Oberon 200 ml,Oberon 50 ml,Oberon 500 ml,Omite 1 ltr ," +
            "Omite 100 ml,Omite 250 ml,Omite 500 ml,Pegasus 25 gm,Pegasus 250 gm,Pegasus 500 gm," +
            "Planofix 1 ltr ,Planofix 100 ml,Planofix 250 ml,Planofix 500 ml,Polyram 400 gm,Polyram 800 gm," +
            "Predator 1 ltr,Predator 250 ml,Predator 5 ltr,Predator 500 ml,Proclaim 100 gm,Proclaim 250 gm," +
            "Proclaim 50 gm,Proclaim 500 gm,Profiler 1 Kg," + "Profiler 2 kg,Profiler 250 gm,Progibb 1 gm,Progibb 10 gm,Progibb 100 gm,Progibb 25 gm," +
            "Progibb 5 gm,Protocol 1 kg,Protocol 500 gm,Pursuit BASF 250 ml," +
            "Ralligold 100 gm,Ralligold 200 gm,Ralligold 4 Kg,Redomil gold 1 kg ," +
            "Redomil Gold 100 gm,Redomil Gold 250 gm,Redomil Gold 500 gm,Regent -Gr- 1 Kg," +
            "Regent -Gr- 5 Kg,Regent-SC 1 ltr,Regent-SC 100 ml,Regent-SC 250 ml,Regent-SC 500 ml," +
            "Revus 1 ltr ,Revus 160 ml,Revus 500 ml ,Roko 1 kg ,Roko 250 gm ,Roko 500 gm ," +
            "Round Up  5 ltr ,Round Up 1 ltr ,Round Up 20 ltr ,Round Up 500 ml,Round up Speed up 1 ltr ," +
            "Round up Speed up 100 ml,Sanrakshak Kit ,Sanvardhan 40 kg,Score 1 ltr  ,Score 100 ml ," +
            "Score 250 ml ,Score 50 ml ,Score 500 ml ,Sectin 1 kg,Sectin 100 gm,Sectin 600 gm,Sempra 36 gm," +
            "Sencor 100 gm,Silica Fert 1 kg,Silica Fert 1 ltr,Silica Fert 100 gm,Silica Fert 2 kg," +
            "Silica Fert 250 gm,Silica Fert 250 ml,Silica Fert 500 gm,Silica Fert 500 ml,Sizer 1 ltr," +
            "Sizer 10 ltr,Sizer 250 ml,Sizer 5 ltr,Sizer 500 ml,Solomon 1 ltr,Solomon 100 ml,Solomon 250 ml," +
            "Solomon 500 ml,Spintor 75 ,Sprit plus 8 gm,Spurada 1 ltr ,Spurada 5 ltr ,Starlet 1 kg," +
            "Starlet 250 gm,Starlet 500 gm,Sticker 1 ltr ,Sticker 100 ml,Sticker 250 ml ,Sticker 5 ltr ," +
            "Sticker 500 ml ,Sultaf 500 gm,Sumiciden 1 ltr ," +
            "Sumiciden 250 ml,Sumiciden 500 ml,Sun bio Safe  1 ltr ,Sun boost 1 ltr ,Sun cytozyme 1  ltr ," +
            "Sun cytozyme 250 ml,Sun cytozyme 500 ml,Sun Ethephone 1 ltr ,Sun Ethephone 100 ml," +
            "Sun Ethephone 250 ml,Sun Ethephone 500 ml,Sunflower 1 ltr ,Sunflower 250 ml," +
            "Sunflower 5 ltr ,Sunflower 500 ml,Sunshine 0:0:50 1 kg,Sunshine 0:52:34 1 kg," +
            "Sunshine 12:61:0 1 kg,Sunshine 13:0:45 1 kg,Sunshine 19:19:19 1 kg,Sunshine Calcium Nitrate 1 kg," +
            "Sunshine Dorsol 1 ltr ,Sunsigma 1 ltr ," +
            "Sunsigma 500 ml,Suvan 1 ltr,Suvan 100 ml,Suvan 250 ml,Suvan 5 ltr,Suvan 500 ml," +
            "Sweetner 1 ltr ,Sweetner 1 ltr ,Sweetner 5 ltr ,Sweetner 500 ml ,Syathane 500 gm,Systhane 100 gm," +
            "Taffin 75 ml,Tafgor 1 ltr,Tafgor 250 ml,Tafgor 5 ltr ,Tafgor 500 ml,Takumi 100 gm," +
            "Takumi 250 gm ,Takumi 500 gm ,Taqat 1 kg ,Taqat 250 gm,Taqat 500 gm,Targa supar 100 ml," +
            "Targa supar 250 ml,Targa supar 500 ml,Tata Bahar  500 ml,Tata Bahar 1 ltr,Tata Bahar 250 ml," +
            "Tata Bahar 5 ltr,Tatafen 1 ltr ,Tatafen 100 ml ," +
            "Tatafen 250 ml ,Tatafen 5 ltr ,Tatafen 500 ml ,Thionutri 5 kg,Thionutri 500 gm," +
            "Tilt  500 ml,Tilt 1 ltr,Tilt 100 ml,Tilt 250 ml,Tml 777 1 ltr ,Tml 777 100  ml," +
            "Tml 777 250  ml,Tml 777 50  ml,Tml 777 500 ml,Tracel-2 500 gm,Tracer 7 ml," +
            "Tracer 75 ml,Trex 250 ml,Trex 500 ml,Tynzer 15 ml,Tynzer 30 ml,Ultrakem 1 kg," +
            "Ultrakem 500 gm,Umet 1 kg,Validamycin  1 ltr ,Validamycin 500 ml,Vesticor 150 ml," +
            "Vesticor 30 ml,Vesticor 60 ml,Virasan 1 kg,Virasan 100 gm,Virasan 250 gm,Virasan 500 gm," +
            "Virtako 2.5 kg ,Virtako 5 kg ,Voliam Flexi 100 ml,Voliam Flexi 200 ml,Voliam Flexi 500 ml," +
            "Vruddhi 1 ltr,Vruddhi 100 ml,Vruddhi 250 ml,Vruddhi 5 ltr,Vruddhi 500 ml,Weedmar 500 gm," +
            "Weemar supar 1 ltr ,Weemar supar 5 ltr ,Weemar supar 500 ml ,Wetcit 100 ml,Whip supar 100 ml," +
            "Whip supar 250 ml,Whip supar 500 ml,Xelora 80 ml,Zampro 1 ltr ,Zampro 400 ml,Zanthonil 1 ltr," +
            "Zanthonil 250 ml,Zanthonil 5 ltr,Zanthonil 500 ml,Zink Fert 1 kg,Zink Fert 250 gm," +
            "Zink Fert 500 gm").split(",");

    public static final String API_GET_SCHEMES_LIST = "/schemes" ;
}


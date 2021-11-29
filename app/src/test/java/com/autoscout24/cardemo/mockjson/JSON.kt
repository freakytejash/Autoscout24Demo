package com.autoscout24.cardemo.mockjson

object JSON {
    const val getAllCars = "[\n" +
            "    {\n" +
            "        \"id\": 1,\n" +
            "        \"make\": \"BMW\",\n" +
            "        \"model\": \"316i\",\n" +
            "        \"price\": 13000,\n" +
            "        \"firstRegistration\": \"01-2000\",\n" +
            "        \"mileage\": 25000,\n" +
            "        \"fuel\": \"Gasoline\",\n" +
            "        \"images\": [\n" +
            "            {\n" +
            "                \"url\": \"https://loremflickr.com/g/320/240/bmw\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"url\": \"https://loremflickr.com/g/640/480/bmw\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"url\": \"https://loremflickr.com/g/1600/1200/bmw\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"description\": \"Almost like new. Full service history\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"id\": 2,\n" +
            "        \"make\": \"Audi\",\n" +
            "        \"model\": \"A8\",\n" +
            "        \"fuel\": \"Gasoline\",\n" +
            "        \"modelline\": \"quattro\",\n" +
            "        \"price\": 16000,\n" +
            "        \"firstRegistration\": \"02-2008\",\n" +
            "        \"mileage\": 0,\n" +
            "        \"seller\": {\n" +
            "            \"type\": \"Private\",\n" +
            "            \"phone\": \"+123456789\",\n" +
            "            \"city\": \"München\"\n" +
            "            },\n" +
            "        \"description\": \"No description available.\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"id\": 3,\n" +
            "        \"make\": \"Audi\",\n" +
            "        \"model\": \"A7\",\n" +
            "        \"price\": 20000,\n" +
            "        \"mileage\": 0,\n" +
            "        \"fuel\": \"Gasoline\",\n" +
            "        \"seller\": {\n" +
            "            \"type\": \"Dealer\",\n" +
            "            \"phone\": \"+123456789\",\n" +
            "            \"city\": \"Stuttgart\"\n" +
            "            },\n" +
            "         \"images\": [\n" +
            "            {\n" +
            "                \"url\": \"https://loremflickr.com/g/480/640/audi\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"url\": \"https://loremflickr.com/g/1600/1200/audi\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"url\": \"https://loremflickr.com/g/640/480/audi\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"url\": \"https://loremflickr.com/g/640/480/audi\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"url\": \"https://loremflickr.com/g/480/640/audi\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"description\": \"Good condition, had an accident two years ago.\"\n" +
            "    },\n" +
            "     {\n" +
            "        \"id\": 4,\n" +
            "        \"make\": \"Ford\",\n" +
            "        \"model\": \"Mondeo\",\n" +
            "        \"colour\": \"White\",\n" +
            "        \"price\": 5000,\n" +
            "        \"mileage\": 250000,\n" +
            "        \"fuel\": \"Diesel\",\n" +
            "        \"seller\": {\n" +
            "            \"type\": \"Private\",\n" +
            "            \"phone\": \"+123456789\",\n" +
            "            \"city\": \"Rosenheim\"\n" +
            "            },\n" +
            "         \"images\": [\n" +
            "            {\n" +
            "                \"url\": \"https://loremflickr.com/g/480/640/ford\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"url\": \"https://loremflickr.com/g/1200/1600/ford\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"url\": \"https://loremflickr.com/g/640/480/ford\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"url\": \"https://loremflickr.com/g/640/480/ford\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"url\": \"https://loremflickr.com/g/480/640/ford\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"description\": \"Engine replaced at 180000km.\"\n" +
            "    },\n" +
            "     {\n" +
            "        \"id\": 5,\n" +
            "        \"make\": \"Porsche\",\n" +
            "        \"model\": \"911\",\n" +
            "        \"colour\": \"Brown\",\n" +
            "        \"price\": 100000,\n" +
            "        \"mileage\": 4500,\n" +
            "        \"fuel\": \"Gasoline\",\n" +
            "        \"seller\": {\n" +
            "            \"type\": \"Private\",\n" +
            "            \"phone\": \"+123456789\",\n" +
            "            \"city\": \"Köln\"\n" +
            "            },\n" +
            "         \"images\": [\n" +
            "            {\n" +
            "                \"url\": \"https://loremflickr.com/g/480/640/porsche\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"url\": \"https://loremflickr.com/g/1200/1600/porsche\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"url\": \"https://loremflickr.com/g/480/640/porsche\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"description\": \"Engine replaced at 180000km.\"\n" +
            "    }\n" +
            "\n" +
            "]"

    const val getNotes = "[\n" +
            "    {\n" +
            "        \"vehicleId\": 2,\n" +
            "        \"note\": \"good price\"\n" +
            "    }, {\n" +
            "        \"vehicleId\": 4,\n" +
            "        \"note\": \"mileage seems high\"\n" +
            "    }\n" +
            "]"
}
# ik
API:

Post /shop-api/device


 {
        "price": 2600,
        "modelName": "MiBand 5",
        "deviceType": "Tablet",
        "colorName": "PURPLE",
     "manufactureDate": "02.01.2019",
        "manufacturer": "Xiaomi"}

Post /shop-api/device


 {
        "price": 5889000,
        "modelName": "Galaxy S10 Plus",
        "deviceType": "Smartphone",
    "colorRGB": 16519104,
        "manufactureDate": "27.04.2019",
        "manufacturer": "Samsung"}

Get /shop-api/device/{id}


Post /shop-api/customer

{
"birthdate": "03.01.2001",
 "firstName": "Kolya",
 "middleName": "Pupkin",
 "lastName": "Vasilyevich"

}

Post /shop-api/bill{
    "customerId": 2,
    "items": [
{
  "deviceId": 56,
            "quantity": 13,
            "price": 40
}
 ],
    "purchaseDateTime": "01.02.1998 12:36:04"
}

There were made filters and sorters according to the requirements which were sent via e-mail on April the 25th.
Though still there is quite a few things to improve and add in the functions.
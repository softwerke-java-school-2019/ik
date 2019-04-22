# ik
API:

Post /shop-api/device
{
	"price" : "2300.50",
	"model" : "MiBand 3",
	"color" : "BLACK",
	"date" : "2019-03-31T19:05:35.195Z",
	"manufacturer" : "Xiaomi"
}

Get /shop-api/device/{id}


Post /shop-api/customer{  "firstName" : "Kolya", "secondName" : "Pupkin", "thirdName" : "Vasilyevich", "bornDate" : "03.01.2001" }

There was made minimum realization of search (for Device only)  so far
with simple filter by:
-Price
-Model
-Color
-Manufacturer
example: GET /shop-api/device?filterByColor=BLACK&filterByManufacturer=Samsung
#### run console app (1999 ver)
gradle run --console=plain

#### run web app (2020 ver)
gradle bootrun

`POST localhost:8080/api/v2020/purchase`

request example

```
{
	"transaction" : "b, c, w",
	"payment" : 5.0
}
```

`GET localhost:8080/api/v2020/status`
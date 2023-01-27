# examen-seguros
Examen
<pre><h3 dir="auto"><a id="user-content-nombre-leonardo-arevaloemailleonardojosearevalogmailcomcel1125046726" class="anchor" aria-hidden="true" href="#nombre-leonardo-arevaloemailleonardojosearevalogmailcomcel1125046726"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M7.775 3.275a.75.75 0 001.06 1.06l1.25-1.25a2 2 0 112.83 2.83l-2.5 2.5a2 2 0 01-2.83 0 .75.75 0 00-1.06 1.06 3.5 3.5 0 004.95 0l2.5-2.5a3.5 3.5 0 00-4.95-4.95l-1.25 1.25zm-4.69 9.64a2 2 0 010-2.83l2.5-2.5a2 2 0 012.83 0 .75.75 0 001.06-1.06 3.5 3.5 0 00-4.95 0l-2.5 2.5a3.5 3.5 0 004.95 4.95l1.25-1.25a.75.75 0 00-1.06-1.06l-1.25 1.25a2 2 0 01-2.83 0z"></path></svg></a>
Nombre: Leonardo Arevalo
Email:leonardojosearevalo@gmail.com
cel:1125046726
</h3>

<h2 dir="auto"><a id="user-content-configuracion" class="anchor" aria-hidden="true" href="#configuracion"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M7.775 3.275a.75.75 0 001.06 1.06l1.25-1.25a2 2 0 112.83 2.83l-2.5 2.5a2 2 0 01-2.83 0 .75.75 0 00-1.06 1.06 3.5 3.5 0 004.95 0l2.5-2.5a3.5 3.5 0 00-4.95-4.95l-1.25 1.25zm-4.69 9.64a2 2 0 010-2.83l2.5-2.5a2 2 0 012.83 0 .75.75 0 001.06-1.06 3.5 3.5 0 00-4.95 0l-2.5 2.5a3.5 3.5 0 004.95 4.95l1.25-1.25a.75.75 0 00-1.06-1.06l-1.25 1.25a2 2 0 01-2.83 0z"></path></svg></a><b>Configuracion</b></h2>
<table border="1">
<tbody><tr>
</tr><tr>
<td>
application.properties cambiar el key si presenta 
HTTP/1.1 503 Unauthorized
</td>
<td><b>
{
  "Code": "ServiceUnavailable",
  "Message": "The allowed number of requests has been exceeded.",
  "Reference": "/currentconditions/v1/7894?apikey=KJNvGmRyD2NKuA0fXlPvmGNVCpN54YNS"
}
</b>
</td>
<td>
developer.accuweather.apikey = KJNvGmRyD2NKuA0fXlPvmGNVCpN54YNS
</td>
</tr>

<tr>
</tr><tr>
<td>
<b>Base de Datos - H2 - men en memoria</b>
</td>
<td>
http://localhost:8080/h2-console/login.jsp?jsessionid=f2893dae8ea3d06ad2accc06cdffe79a
</td>
<td>
User: sa / pass: password / definido en application.properties 
</td>
</tr>

<tr>
</tr><tr>
<td>
<b>Documentacion</b>
</td><td>
swagger
</td>
<td>
http://localhost:8080/swagger-ui/#/weather-controller
</td>
</tr>

<tr>
</tr><tr>
<td>
<b>Test</b>
</td>
<td>
Spock groovy
</td>
<td>
Junit - Mockito
</td>
</tr>



</tbody></table>


<h2 dir="auto"><a id="user-content-link" class="anchor" aria-hidden="true" href="#link"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M7.775 3.275a.75.75 0 001.06 1.06l1.25-1.25a2 2 0 112.83 2.83l-2.5 2.5a2 2 0 01-2.83 0 .75.75 0 00-1.06 1.06 3.5 3.5 0 004.95 0l2.5-2.5a3.5 3.5 0 00-4.95-4.95l-1.25 1.25zm-4.69 9.64a2 2 0 010-2.83l2.5-2.5a2 2 0 012.83 0 .75.75 0 001.06-1.06 3.5 3.5 0 00-4.95 0l-2.5 2.5a3.5 3.5 0 004.95 4.95l1.25-1.25a.75.75 0 00-1.06-1.06l-1.25 1.25a2 2 0 01-2.83 0z"></path></svg></a><b>Link</b></h2>
<table border="1">

<h3>Consulta de Key de Localidades</h3>
http://localhost:8080/cities/50
<h3>Consulta de Clima por Localidades</h3>
http://localhost:8080/weather/7894
http://localhost:8080/weather/28143
<h3>Consulta en la base de consultas ejecutadas</h3>
http://localhost:8080/weather

<tbody><tr>
<td>
 <b> Link para consultar las ciudades 50,100,150 limites</b>
</td>  
<td>
  <b>con el key de ciudad se consulta el clima por ejemplo 7898 buenos aires</b>
</td>  
<td>
  <b>con el key de ciudad se consulta el clima otro ejemplo</b>
</td>  
<td>
  <b>con este link se consulta lo que esta en base de datos, todas los consultas realizas </b>
</td>  
</tr>


<tr>
<td>
  http://localhost:8080/cities/50
</td>  
<td>
  http://localhost:8080/weather/7894
</td>  
<td>
  http://localhost:8080/weather/28143
</td>  
<td>
  http://localhost:8080/weather
</td>  
</tr>

<tr>
<td>
  curl -X GET "http://dataservice.accuweather.com/currentconditions/v1/topcities/50?apikey=KJNvGmRyD2NKuA0fXlPvmGNVCpN54YNS"
</td>  
<td>
  curl -X GET "http://dataservice.accuweather.com/currentconditions/v1/7894?apikey=KJNvGmRyD2NKuA0fXlPvmGNVCpN54YNS"
</td>  
<td>
curl -X GET "http://dataservice.accuweather.com/currentconditions/v1/28143?apikey=KJNvGmRyD2NKuA0fXlPvmGNVCpN54YNS"
</td>  
<td>
 de labase y con el link   curl -X GET "http://dataservice.accuweather.com/currentconditions/v1/7894?apikey=KJNvGmRyD2NKuA0fXlPvmGNVCpN54YNS"
</td>  
</tr>

</tbody></table>
</pre>

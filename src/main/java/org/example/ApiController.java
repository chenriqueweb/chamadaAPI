package org.example;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ApiController {

    @GetMapping("/msTemplate")
    public String chamarAPI(@RequestParam String parametro) {

        // URL da API externa
        String apiUrl = "http://localhost:8080/msTemplate/LogSync?qtd={parametro}";

        // Token de autenticação
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6ImtXYmthYTZxczh3c1RuQndpaU5ZT2hIYm5BdyJ9.eyJhdWQiOiJkMTk3Y2E4OC03OGQyLTRlM2QtYTVmMS0zYmM5ZDhjYjBkODkiLCJpc3MiOiJodHRwczovL2xvZ2luLm1pY3Jvc29mdG9ubGluZS5jb20vNWE4NmIzZmItNDIxMy00OWNkLWI0ZDYtYmU5MTQ4MmFkM2MwL3YyLjAiLCJpYXQiOjE3MDg2MjMzNzgsIm5iZiI6MTcwODYyMzM3OCwiZXhwIjoxNzA4NjI3Mjc4LCJhaW8iOiJFMlZnWUpDcldDd1lmNHJqOGZuUWovTEZYeWF4YlBiY1ZDTVU5VXBTVkhqdFBSYStOMjhCIiwiYXpwIjoiZDE5N2NhODgtNzhkMi00ZTNkLWE1ZjEtM2JjOWQ4Y2IwZDg5IiwiYXpwYWNyIjoiMSIsIm9pZCI6IjJjZDA3Mjk0LWIyOTctNDU2Ny04YWI0LTU0YTliYWIzNTJlYyIsInJoIjoiMC5BU1lBLTdPR1doTkN6VW0wMXI2UlNDclR3SWpLbDlIU2VEMU9wZkU3eWRqTERZa21BQUEuIiwicm9sZXMiOlsic2VydmljZSJdLCJzdWIiOiIyY2QwNzI5NC1iMjk3LTQ1NjctOGFiNC01NGE5YmFiMzUyZWMiLCJ0aWQiOiI1YTg2YjNmYi00MjEzLTQ5Y2QtYjRkNi1iZTkxNDgyYWQzYzAiLCJ1dGkiOiJZNWhwamZmaHZFaVFiZ0FjSlh5UkFBIiwidmVyIjoiMi4wIn0.hPuGX9Tt0azVwZy0Bc8WJjFrgnebo5KVbgpKM89SA1DMicfPSA0rINyKUIBVyZRhNk4ZKIur_5zXv-I2naOfm-xzDo4uK5q1s5YirR60KPlmeDl6y6SrRUtsuwHnvfaQla4NhLvlT-QkvB2TnB1IqpgUiln4r4IMTw3SvsmLeb0jBVrioVNZoOJjiLAiR0PxjOfuJRjHOucNTiJlWtGQC0MZCnZ7E6O-tCvzlXF9l1Yx6h5LglU0ue0OirKESwLpYObrxxxrdHcrTcfHThAAqsVDa6AfcVHRcGNl786mX6ECyLkbGQOg-ZateGWYp_rVaK_UznJdmqjoykweMWBcFQ";

        // Criando um objeto RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Adicionando o cabeçalho de autorização
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Chamando a API e passando o parâmetro
        ResponseEntity<String> resposta = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, String.class, parametro);

        // Retornando a resposta da API
        return resposta.getBody();
    }
}

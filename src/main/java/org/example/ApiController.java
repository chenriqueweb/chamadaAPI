package org.example;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private RestClientConfiguration restClientConfiguration;

    @GetMapping("/msTemplate")
    public String chamarAPI(@RequestParam String parametro) throws Exception {

        // URL da API externa
        // String apiUrl = "http://localhost:8080/msTemplate/LogSync?qtd={parametro}";
        String apiUrl = "https://sit-apimstemplatejava.viavarejo.com.br/msTemplate/LogSync?qtd={parametro}";

        // Token de autenticação
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6ImtXYmthYTZxczh3c1RuQndpaU5ZT2hIYm5BdyJ9.eyJhdWQiOiJkMTk3Y2E4OC03OGQyLTRlM2QtYTVmMS0zYmM5ZDhjYjBkODkiLCJpc3MiOiJodHRwczovL2xvZ2luLm1pY3Jvc29mdG9ubGluZS5jb20vNWE4NmIzZmItNDIxMy00OWNkLWI0ZDYtYmU5MTQ4MmFkM2MwL3YyLjAiLCJpYXQiOjE3MDg2MjY4MzQsIm5iZiI6MTcwODYyNjgzNCwiZXhwIjoxNzA4NjMwODkwLCJhaW8iOiJBV1FBbS84V0FBQUFMT0NBa0hnVUdaMDlHTW9PR0gwcVZIMmpvM2IvRjBwTjQwTTF3Tlp1RFhBbmNGU2c3OVdoTmhiUkxIZnNTVGI4NXZ5TEc5VlMvWUNsU0NFL3FiQjZqYmZtbUtodzVVMEQrS04vUENNV1I3T0h0RkVFRkdabTljSm5qZmtLR3NycyIsImF6cCI6ImQxOTdjYTg4LTc4ZDItNGUzZC1hNWYxLTNiYzlkOGNiMGQ4OSIsImF6cGFjciI6IjAiLCJlbWFpbCI6ImNhcmxvcy5oc2lsdmFAZ3J1cG9jYXNhc2JhaGlhLmNvbS5iciIsIm5hbWUiOiJDQVJMT1MgSEVOUklRVUUgREEgU0lMVkEiLCJvaWQiOiI3ZjNiMDJlYS1jMzM2LTQ2OGMtODYzNy1jODkwOWNmOWQ0MTUiLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJjYXJsb3MuaHNpbHZhQHZpYXZhcmVqby5jb20uYnIiLCJyaCI6IjAuQVNZQS03T0dXaE5DelVtMDFyNlJTQ3JUd0lqS2w5SFNlRDFPcGZFN3lkakxEWWttQU1jLiIsInJvbGVzIjpbIkxlZ2FjeURhdGFfVXNlciIsIkRhdF9TY3JhcF9BZG1pbiIsIlN1cHBseVN0b3JlX0JvbmQiLCJMZWdhY3lEYXRhX0FkbWluIiwiYWRtaW4iLCJTdXBwbHlTdG9yZSJdLCJzY3AiOiJkZWZhdWx0Iiwic3ViIjoiVkZkR21MMGRaV0lDWHBuS3FRbW93c2dWcmJqTWJaMzJ4NUQ2Q1lCbGE0ZyIsInRpZCI6IjVhODZiM2ZiLTQyMTMtNDljZC1iNGQ2LWJlOTE0ODJhZDNjMCIsInV0aSI6ImFWeEVTN0w0eGstdHRHaFJJdUxCQUEiLCJ2ZXIiOiIyLjAiLCJvbnByZW1pc2Vzc2FtYWNjb3VudG5hbWUiOiI0OTYwMDAwMDgzIn0.g4OUjFSfNU2aJNf2kTtJA_9XvEMMbRU-QhAvyPkHoJC-F4ne_M8AGyGRzHkGqPihVrCsG1CnWB3VjlcU-KLhoiBquEr4vm9l8_F1slw0TOJGzO4A0tQatGHHGpJmLhhk4yOpdrREEYLC4tT1mX9jsX-y4SRZ8PMe29JKqAFGZebMdtPtber5Zsj8XeKvvpV6X1UI6PWO6dlRzeOdb1UUqtmU7u4Y8MUgYPaqgtcqjSol--zOhuoOXCqoTc6sN-VDm6LRRFExDh_XvAnaJCTUX8ekKgoE5x-evEGkqq0og_zisqWhoNIHR3iTgwN2ClWkTOsUOFQWL5sHEAjPW3Ik9Q";

        // Criando um objeto RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        RestClientConfiguration restClientConfiguration = new RestClientConfiguration();
        restClientConfiguration.restTemplate();

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
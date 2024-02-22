//package org.example;
//
//import org.apache.hc.client5.http.classic.HttpClient;
//import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
//import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
//import org.apache.hc.client5.http.socket.ConnectionSocketFactory;
//import org.apache.hc.client5.http.socket.PlainConnectionSocketFactory;
//import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactory;
//import org.apache.hc.core5.http.URIScheme;
//import org.apache.hc.core5.http.config.Registry;
//import org.apache.hc.core5.http.config.RegistryBuilder;
//import org.apache.hc.core5.ssl.SSLContextBuilder;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.http.client.ClientHttpRequestFactory;
//import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
//import org.springframework.web.client.RestTemplate;
//
//import javax.net.ssl.SSLContext;
//import java.security.KeyManagementException;
//import java.security.KeyStoreException;
//import java.security.NoSuchAlgorithmException;
//import java.security.cert.X509Certificate;
//
//
//@Configuration
//public class RestClientConfiguration {
//
//    private static final Logger logger = LoggerFactory.getLogger(RestClientConfiguration.class);
//
//    @Primary
//    @Bean("restClient")
//    public RestTemplate restTemplate()  throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
//        final var restTemplate = new RestTemplate();
//
//        ClientHttpRequestFactory requestFactory = disableSSlHttpClient5();
//        restTemplate.setRequestFactory(requestFactory);
//        return restTemplate;
//    }
//
//    HttpComponentsClientHttpRequestFactory disableSSlHttpClient5()
//            throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
//
//        SSLContext sslContext = SSLContextBuilder.create()
//                .loadTrustMaterial((X509Certificate[] certificateChain, String authType) -> true)  // <--- accepts each certificate
//                .build();
//
//        Registry<ConnectionSocketFactory> socketRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
//                .register(URIScheme.HTTPS.getId(), new SSLConnectionSocketFactory(sslContext))
//                .register(URIScheme.HTTP.getId(), new PlainConnectionSocketFactory())
//                .build();
//
//        HttpClient httpClient = HttpClientBuilder.create()
//                .setConnectionManager(new PoolingHttpClientConnectionManager(socketRegistry))
//                .setConnectionManagerShared(true)
//                .build();
//
//        return new HttpComponentsClientHttpRequestFactory(httpClient);
//    }
//
//}

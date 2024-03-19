package com.joaovellenich.fuel.infra.gateways;

import com.joaovellenich.fuel.application.gateways.CarGateway;
import com.joaovellenich.fuel.infra.security.SecurityFilter;
import com.joaovellenich.fuel.infra.security.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.util.UUID;

public class CarRepositoryGateway implements CarGateway {
    @Value("${api.car.url}")
    private String url;

    @Override
    public void updateCarKm(UUID carId, Double km, String token) throws Exception{
        String kmString = km.toString().replace(",", ".");
        String requestBody = String.format("{\"carId\": \"%s\", \"km\": %s}", carId.toString(), kmString);
        String requestAuth = String.format("Bearer%s", token);
        String requestUrl = String.format("%s/cars/updateKm", this.url);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(String.format(requestUrl)))
                .header("Authorization", requestAuth)
                .header("Content-Type", "application/json")
                .method("PATCH", BodyPublishers.ofString(requestBody))
                .build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}

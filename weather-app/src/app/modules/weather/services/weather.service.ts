import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class WeatherService {
  private readonly WEATHER_API_KEY = environment.WEATHER_API_KEY || '';
  private readonly WEATHER_API_URL = environment.WEATHER_API_URL || '';
  private readonly IPIFY_GEOIP_URL = environment.IPIFY_GEOIP_URL || '';
  private readonly IPIFY_GEOIP_APIKEY = environment.IPIFY_GEOIP_APIKEY || '';
  private readonly IPIFY_GETIP_URL = environment.IPIFY_GETIP_URL || '';

  constructor(private http: HttpClient) {}

  getIp(): Observable<any> {
    return this.http.get(this.IPIFY_GETIP_URL);
  }

  getGeoLocation(ip: string): Observable<any> {
    return this.http.get(
      `${this.IPIFY_GEOIP_URL}?apiKey=${this.IPIFY_GEOIP_APIKEY}&ipAddress=${ip}`
    );
  }

  getWeatherData(cityName: string): Observable<any> {
    return this.http.get(
      `${this.WEATHER_API_URL}?q=${cityName}&units=metric&mode=json&appid=${this.WEATHER_API_KEY}`,
      {}
    );
  }
}

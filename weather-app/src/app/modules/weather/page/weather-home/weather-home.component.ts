import { Component, OnDestroy, OnInit } from '@angular/core';
import { WeatherService } from '../../services/weather.service';
import { WeatherDatas } from 'src/app/models/interfaces/weatherdatas.interface';
import { Subject, switchMap, takeUntil } from 'rxjs';
import { faMagnifyingGlass } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-weather-home',
  templateUrl: './weather-home.component.html',
  styleUrls: ['./weather-home.component.css'],
})
export class WeatherHomeComponent implements OnInit, OnDestroy {
  private readonly destroy$: Subject<void> = new Subject();
  weather!: WeatherDatas;
  searchIcon = faMagnifyingGlass;
  cityName!: string;
  constructor(private weatherService: WeatherService) {}

  ngOnInit(): void {
    // this.getWeatherData();
    this.getWeatherByGeoLocation();
  }

  // getWeatherData(): void {
  //   this.weatherService
  //     .getIp()
  //     .pipe(takeUntil(this.destroy$))
  //     .subscribe({
  //       next: (responseIp) => {
  //         this.weatherService
  //           .getGeoLocation(responseIp.ip)
  //           .pipe(takeUntil(this.destroy$))
  //           .subscribe({
  //             next: (responseGeo) => {
  //               let city = responseGeo.location.city;
  //               let country = responseGeo.location.country;
  //               this.weatherService
  //                 .getWeatherData(`${city},${country}`)
  //                 .pipe(takeUntil(this.destroy$))
  //                 .subscribe({
  //                   next: (responseWeather) => {
  //                     responseWeather && (this.weather = responseWeather);
  //                     console.log(this.weather);
  //                   },
  //                   error: (error) =>
  //                     console.error(`Erro ao obter dados do clima: ${error}`),
  //                 });
  //             },
  //             error: (error) =>
  //               console.error(`Erro ao obter localização atual: ${error}`),
  //           });
  //       },
  //       error: (error) =>
  //         console.log(`Erro ao capturar endereço do usuário: ${error}`),
  //     });
  // }

  getWeatherByGeoLocation(): void {
    this.weatherService
      .getIp()
      .pipe(
        switchMap((responseIp) =>
          this.weatherService.getGeoLocation(responseIp.ip)
        ),
        switchMap((responseGeo) =>
          this.weatherService.getWeatherData(
            `${responseGeo.location.city},${responseGeo.location.country}`
          )
        ),
        takeUntil(this.destroy$)
      )
      .subscribe({
        next: (responseWeather) => {
          this.weather = responseWeather;
          console.log(this.weather);
        },
        error: (error) =>
          console.error(`Erro ao obter dados do clima: ${error}`),
      });
  }

  getWeatherBySearchLocation(location: string): void {
    this.weatherService
      .getWeatherData(location)
      .pipe(takeUntil(this.destroy$))
      .subscribe((weatherData) => (this.weather = weatherData));
  }

  onSubmit(): void {
    this.getWeatherBySearchLocation(this.cityName);
    this.cityName = '';
  }

  ngOnDestroy(): void {
    this.destroy$.next();
    this.destroy$.complete();
  }
}

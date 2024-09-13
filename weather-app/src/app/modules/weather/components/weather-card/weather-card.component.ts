import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';
import {
  faDroplet,
  faTemperatureHigh,
  faTemperatureLow,
  faWind,
} from '@fortawesome/free-solid-svg-icons';

import { WeatherDatas } from 'src/app/models/interfaces/weatherdatas.interface';

@Component({
  selector: 'app-weather-card',
  templateUrl: './weather-card.component.html',
  styleUrls: ['./weather-card.component.scss'],
})
export class WeatherCardComponent implements OnChanges {
  @Input() weather!: WeatherDatas;
  image: string = '';

  minTemperatureIcon = faTemperatureLow;
  maxTemperatureIcon = faTemperatureHigh;
  humidityIcon = faDroplet;
  windIcon = faWind;

  constructor() {}

  ngOnChanges(changes: SimpleChanges): void {
    if ('weather' in changes) {
      this.image = `../../../assets/${this.weather.weather[0].main}.jpg`;
    }
  }
}

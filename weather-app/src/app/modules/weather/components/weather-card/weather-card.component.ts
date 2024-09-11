import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { WeatherDatas } from 'src/app/models/interfaces/weatherdatas.interface';

@Component({
  selector: 'app-weather-card',
  templateUrl: './weather-card.component.html',
  styleUrls: ['./weather-card.component.scss'],
})
export class WeatherCardComponent implements OnChanges {
  @Input() weather!: WeatherDatas;
  image: string = ''
  constructor() {}

  ngOnChanges(changes: SimpleChanges): void {
    if('weather' in changes){
      this.image = `background-image: url('../../../assets/${this.weather.weather[0].main}.jpg'); background-size: 100% 100%; background-repeat: no-repeat;`;
    }
  }
}

import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-weather-card',
  templateUrl: './weather-card.component.html',
  styleUrls: ['./weather-card.component.scss'],
})
export class WeatherCardComponent implements OnChanges {
  @Input() weather: string = '';
  @Input() temperature!: number;
  @Input() main: string = '';
  image: string = 'background-image: url("../../../assets/Sunny.jpg"); background-size: 100% 100%; background-repeat: no-repeat;`;'
  constructor() {}

  ngOnChanges(changes: SimpleChanges): void {
    if('main' in changes){
      this.image = `background-image: url('../../../assets/${this.main}.jpg'); background-size: 100% 100%; background-repeat: no-repeat;`;
    }
  }
}

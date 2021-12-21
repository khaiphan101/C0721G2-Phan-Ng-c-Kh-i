import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  display:string = '';


  btn(num: string) {
    this.display += num;
  }

  solve() {
    this.display = eval(this.display);
  }

  clearAll() {
    this.display = '';
  }
}

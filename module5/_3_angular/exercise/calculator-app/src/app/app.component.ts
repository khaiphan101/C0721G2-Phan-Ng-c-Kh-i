import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  display = '';
  title: string;


  btn(num: string) {
    this.display += num;
  }

  solve() {
    // tslint:disable-next-line:no-eval
    this.display = eval(this.display);
  }

  clearAll() {
    this.display = '';
  }
}

import { Component } from '@angular/core';
import { FormsModule }   from '@angular/forms';

@Component({
  selector: 'my-app',
  template: `
    <h1>{{title}}</h1>
    <h2>{{hero.name}} details!</h2>
    <div><label>id: </label>{{hero.id}}</div>
    <div>
      <label>name: </label>
      <input value="{{hero.name}}" placeholder="hero name"/>
    </div>
  `,
})
//THE ORDER MATTERS!?
export class AppComponent  { 
  title = 'Tour of Heroes'; 
  hero: Hero = { id: 1,
    name: 'WindStorm'
  };
}

export class Hero {
  id: number;
  name: string;
}

hero: Hero = { id: 1,
  name: 'WindStorm'
};

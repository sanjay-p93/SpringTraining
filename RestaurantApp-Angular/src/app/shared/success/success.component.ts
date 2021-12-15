import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-success',
  template: `
  
    <div class="dash">
    <h2 class="success">Order Placed Successfully</h2>
    <button  class="add-button"  routerLink="/home" >
        Home
    </button>
    </div>
  `,
  styles: [`
  .success{
    color:green;
  }
  .add-button {
    padding: .5rem 1.5rem;
    font-size: 1rem;
    margin-bottom: 2rem;
    background-color:rgb(176, 188, 143);
   }
   
   .add-button:hover {
     color: white;
     background-color: #5c5842;
   }

  `]
})
export class SuccessComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}

import { NgModule } from '@angular/core';

import {MatDialogModule} from '@angular/material/dialog';
import {MatToolbarModule} from '@angular/material/toolbar';


const material =
  [
    MatDialogModule,
    MatToolbarModule
    
  ];

@NgModule({
  imports: [material],
  exports:[material]
})
export class MaterialModule { }

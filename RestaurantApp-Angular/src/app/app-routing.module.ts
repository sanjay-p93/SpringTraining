import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { RestaurantComponent } from './restaurant/restaurant.component';
import { ResturantMenuComponent } from './resturant-menu/resturant-menu.component';
import { DashboardguardGuard } from './services/dashboardguard.guard';
import { SuccessComponent } from './shared/success/success.component';

const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'dashboard', component: DashboardComponent,canActivate: [DashboardguardGuard] },
  { path: 'restaurants', component: RestaurantComponent },
  { path: 'menus', component: ResturantMenuComponent },
  { path: 'success', component: SuccessComponent },
  { path: '**', redirectTo: '/dashboard', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

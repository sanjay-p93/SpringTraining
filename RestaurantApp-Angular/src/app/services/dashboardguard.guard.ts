import { Injectable } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AlertDialogComponent } from '../shared/alert-dialog/alert-dialog.component';
import { UserService } from './user.service';

@Injectable({
  providedIn: 'root'
})
export class DashboardguardGuard implements CanActivate {
  
  constructor(
    private userService: UserService,
    private router: Router,
    public dialog: MatDialog
  ) {} 
  canActivate(route: ActivatedRouteSnapshot,state: RouterStateSnapshot): boolean {
    console.log(route);
    console.log(state);

    if(!this.userService.getLoggedUser()){
      const dialogRef = this.dialog.open(AlertDialogComponent, {
        data: {
          title: 'Alert',
          content:`Please sign in to access this page!`
        }
      });
      this.router.navigateByUrl("/signin"); 
    }
    
    if(this.userService.getLoggedUser()?.role==="OWNER"){
      this.router.navigateByUrl("/menus"); 
    }

    if(this.userService.getLoggedUser()?.role==="USER"){
      this.router.navigateByUrl("/restaurants"); 
    }

    return true;
  }
  
}

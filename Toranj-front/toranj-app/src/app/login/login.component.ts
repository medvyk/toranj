import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  email:string='';
  password:string='';
  loginError:string='';
  constructor (public router: Router,
    // public apiService: ApiService,
    private changeDetector: ChangeDetectorRef,
    // public dataService: DataService,
    // public authService: AuthService
    ) { }

  ngOnInit(): void {
  }

  login(){

  }
}

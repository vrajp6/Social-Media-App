// login.component.ts
import { Component } from '@angular/core';
import { AuthenticationService } from '../../../../frontend/src/app/services/authentication.services';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  user = {
    username: '',
    password: ''
  };

  constructor(private authService: AuthenticationService) {}

  onSubmit(): void {
    this.authService.login(this.user).subscribe(
      data => {
        console.log(data);
        // Navigate to the profile or home page upon successful login
      },
      error => {
        console.error(error);
      }
    );
  }
}

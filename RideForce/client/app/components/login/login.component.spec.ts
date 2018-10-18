import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { AppModule } from '../../app.module';
import { By } from '@angular/platform-browser';

import { LoginComponent } from '../login/login.component';

import {APP_BASE_HREF} from '@angular/common';

describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
        imports: [
          AppModule
          ],
        providers: [
          {provide: APP_BASE_HREF, useValue : '/' }
        ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should display Incorrect email or password for nonexistant user', (done) => {

    component.userEmail = 'notrealuser';
    component.userPass = 'notrealpass';
    fixture.debugElement.injector.get(LoginComponent).login();

    fixture.debugElement.query(By.css('input.fadeIn.fourth')).nativeElement.click();
    fixture.detectChanges();

    fixture.whenStable().then(() => {
      let errorMessage = fixture.debugElement.query(By.css('p#errorMessageLogin')).nativeElement.innerText;
      expect(errorMessage).toBe('Incorrect email or password.');
      done();
    });

  });

  it('should display Input validation failed when fields are submitted empty', (done) => {

    component.userEmail = '';
    component.userPass = '';
    fixture.debugElement.injector.get(LoginComponent).login();

    fixture.debugElement.query(By.css('input.fadeIn.fourth')).nativeElement.click();
    fixture.detectChanges();
    
    fixture.whenStable().then(() => {
      let errorMessage = fixture.debugElement.query(By.css('p#errorMessageLogin')).nativeElement.innerText;
      expect(errorMessage).toBe('Input validation failed.');
      done();    
    });

  });

  //there could be more input validation
  it('login component should perform input validation to check that email is submitted in the correct format -- currently not implemented', (done) => {

    component.userEmail = '@';
    component.userPass = 'password';
    fixture.debugElement.injector.get(LoginComponent).login();

    fixture.debugElement.query(By.css('input.fadeIn.fourth')).nativeElement.click();
    fixture.detectChanges();
    
    fixture.whenStable().then(() => {
      let errorMessage = fixture.debugElement.query(By.css('p#errorMessageLogin')).nativeElement.innerText;
      expect(errorMessage).toBe('Input validation failed.');
      done();
    });
    
  });

    //testing password length input validation
    it('password length input validation -- currently not implemented', (done) => {

      component.userEmail = 'email';
      component.userPass = 'longstring12345678sdfghjedrfgtyhujsdfghjsdfghjdfgh';
      fixture.debugElement.injector.get(LoginComponent).login();
  
      fixture.debugElement.query(By.css('input.fadeIn.fourth')).nativeElement.click();
      fixture.detectChanges();
      
      fixture.whenStable().then(() => {
        let errorMessage = fixture.debugElement.query(By.css('p#errorMessageLogin')).nativeElement.innerText;
        expect(errorMessage).toBe('Input validation failed.');
        done();
      });
      
    });

});

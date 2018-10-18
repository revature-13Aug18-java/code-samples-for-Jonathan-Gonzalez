import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UsercardComponent } from './usercard.component';
import { AppModule } from '../../app.module';
import { APP_BASE_HREF } from '../../../../node_modules/@angular/common';

describe('UsercardComponent', () => {
  let component: UsercardComponent;
  let fixture: ComponentFixture<UsercardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
        imports: [
          AppModule
          ],
        providers: [
          {provide: APP_BASE_HREF, useValue : '/' ,
          UsercardComponent}
        ]
    })
    .compileComponents();
  }));

     beforeEach(() => {
    fixture = TestBed.createComponent(UsercardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

     beforeEach(() => {
    fixture = TestBed.createComponent(UsercardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('hide image tests', () => {
    const spyObj = jasmine.createSpy('nativeElement');
    component.hideImage(true);
    expect(component.swipeCardMain).toBeTruthy();
  });
   it('unhide image tests', () => {
    component.hideImage(false);
   });
    it('swipe action right',() => {
     component.swipe(component.SWIPE_ACTION.RIGHT,null);
   })
    it('swipe action left',() => {
    component.swipe(component.SWIPE_ACTION.LEFT,null);
  })
});

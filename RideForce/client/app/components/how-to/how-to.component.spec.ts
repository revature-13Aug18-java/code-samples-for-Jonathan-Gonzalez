import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HowToComponent } from './how-to.component';

describe('HowToComponent', () => {
  let component: HowToComponent;

  beforeEach(() => {
    TestBed.configureTestingModule({providers: [HowToComponent]});
    component = TestBed.get(HowToComponent);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

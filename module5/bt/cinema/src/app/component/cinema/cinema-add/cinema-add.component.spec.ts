import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CinemaAddComponent } from './cinema-add.component';

describe('CinemaAddComponent', () => {
  let component: CinemaAddComponent;
  let fixture: ComponentFixture<CinemaAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CinemaAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CinemaAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BenhAnDetailComponent } from './benh-an-detail.component';

describe('BenhAnDetailComponent', () => {
  let component: BenhAnDetailComponent;
  let fixture: ComponentFixture<BenhAnDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BenhAnDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BenhAnDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

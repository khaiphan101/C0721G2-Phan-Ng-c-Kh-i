import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BenhAnDeleteComponent } from './benh-an-delete.component';

describe('BenhAnDeleteComponent', () => {
  let component: BenhAnDeleteComponent;
  let fixture: ComponentFixture<BenhAnDeleteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BenhAnDeleteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BenhAnDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

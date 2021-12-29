import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BenhAnAddComponent } from './benh-an-add.component';

describe('BenhAnAddComponent', () => {
  let component: BenhAnAddComponent;
  let fixture: ComponentFixture<BenhAnAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BenhAnAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BenhAnAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

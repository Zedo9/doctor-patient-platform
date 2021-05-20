import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SettintgsPageComponent } from './settintgs-page.component';

describe('SettintgsPageComponent', () => {
  let component: SettintgsPageComponent;
  let fixture: ComponentFixture<SettintgsPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SettintgsPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SettintgsPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

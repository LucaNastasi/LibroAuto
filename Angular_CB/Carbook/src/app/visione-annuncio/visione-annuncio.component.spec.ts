import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VisioneAnnuncioComponent } from './visione-annuncio.component';

describe('VisioneAnnuncioComponent', () => {
  let component: VisioneAnnuncioComponent;
  let fixture: ComponentFixture<VisioneAnnuncioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VisioneAnnuncioComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VisioneAnnuncioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

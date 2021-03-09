import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PAnnuncioComponent } from './p-annuncio.component';

describe('PAnnuncioComponent', () => {
  let component: PAnnuncioComponent;
  let fixture: ComponentFixture<PAnnuncioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PAnnuncioComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PAnnuncioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

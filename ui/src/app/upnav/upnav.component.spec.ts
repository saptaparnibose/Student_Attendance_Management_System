import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpnavComponent } from './upnav.component';

describe('UpnavComponent', () => {
  let component: UpnavComponent;
  let fixture: ComponentFixture<UpnavComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpnavComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpnavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

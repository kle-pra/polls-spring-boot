import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PollSmallComponent } from './poll-small.component';

describe('PollSmallComponent', () => {
  let component: PollSmallComponent;
  let fixture: ComponentFixture<PollSmallComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PollSmallComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PollSmallComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

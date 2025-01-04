import { TestBed } from '@angular/core/testing';

import { ExamtimeService } from './examtime.service';

describe('ExamtimeService', () => {
  let service: ExamtimeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ExamtimeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

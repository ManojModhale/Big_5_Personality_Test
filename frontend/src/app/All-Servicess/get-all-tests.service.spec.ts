import { TestBed } from '@angular/core/testing';

import { GetAllTestsService } from './get-all-tests.service';

describe('GetAllTestsService', () => {
  let service: GetAllTestsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GetAllTestsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

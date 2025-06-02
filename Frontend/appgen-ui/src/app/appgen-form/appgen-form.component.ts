import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-appgen-form',
  templateUrl: './appgen-form.component.html',
  styleUrls: ['./appgen-form.component.css']
})
export class AppgenFormComponent {
  formData = {
    compCode: '001',
    userId: 'rmtah',
    sessionId: 'sess123',
    existingCustFlg: 'N',
    applyDate: '26/05/2025',
    accountNo: '',
    custCode: '123456',
    custType: 'BMN',
    marketOfficer: '',
    relManager: '',
    branchCode: '104',
    accountName: 'John Doe Sayadur Rahaman',
    custCategory: 'CEMP',
    relOfficer: '',
    agentFlg: 'N',
    empCategory: '',
    branchManager: 'bmtah',
    proposalType: 'C',
    nameAlias: '',
    rmCode: 'rmt',
    altRmCode: 'RM',
    jointAppFlg: '',
    jointCustId: '',
    subBranch: '',
    agentOutlet: '',
    priorityCenter: '',
    corpCompany: '',
    priorityStatus: 'N',
    priorityRemarks: '',
    leadId: '',
    assessmentType: 'CAS',
    customerCategory: '01'
  };

  constructor(private http: HttpClient) {}

  submitForm() {
    this.http.post('http://localhost:8080/api/appgen/submit', this.formData)
      .subscribe({
        next: (response) => {
          alert('Form submitted successfully!');
          console.log(response);
        },
        error: (error) => {
          alert('Error submitting form.');
          console.error(error);
        }
      });
  }
}
import { Component, OnInit } from '@angular/core';

import { UserService } from '../../../services/user.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.scss']
})
export class UsersComponent implements OnInit {
  displayedColumns: string[] = ['id', 'name', 'cpf', 'birthdate'];
  data: any;

  resultsLength = 0;
  isLoadingResults = true;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.isLoadingResults = true;
    // this.userService.listUsers()
    //   .subscribe((users) => {
    //     this.data = users
    //   });
      this.data = [
        {
          idClient: 1,
          name: "Bárbara Cristina Blank Garibaldi Dakuzaku",
          cpf: "04778862996",
          birthdate:"1987-01-01",
        },
        {
          idClient: 2,
          name: "Tiago",
          cpf: "31229866809",
          birthdate:"1985-08-17",
        },
        {
          idClient: 3,
          name: "Heleno",
          cpf: "006987444562",
          birthdate:"2019-03-08",
        },
        {
          idClient: 4,
          name: "Haru",
          cpf: "566998415236",
          birthdate:"2021-01-10",
        }
        ];
      this.isLoadingResults = false;
  }
}


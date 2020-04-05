import { Component, OnInit } from '@angular/core';

import { OrderService } from 'src/app/services/order.service';


@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.scss']
})
export class OrdersComponent implements OnInit {
  displayedColumns: string[] = ['id', 'name', 'sku', 'price','amount'];
  data: any;

  resultsLength = 0;
  isLoadingResults = true;

  constructor(private orderService: OrderService) { }

  ngOnInit(): void {
    this.isLoadingResults = true;
    // this.orderService.listUsers()
    //   .subscribe((orders) => {
    //     this.data = orders
    //   });
    this.data = [
        {
          idOrder: 1,
          name: "hero Order",
          sku: "0002297272",
          description: "Lorem ipsum dolor sit amet",
          price: "99",
          amount: 10,
        },
        {
          idOrder: 2,
          name: "trumbler Order",
          sku: "00033397272",
          description: "Lorem ipsum dolor sit amet",
          price: "9",
          amount: 23,
        },
        {
          idOrder: 3,
          name: "picanha Order",
          sku: "0002297272",
          description: "Lorem ipsum dolor sit amet",
          price: "23",
          amount: 60,
        },
        {
          idOrder: 4,
          name: "hero Order",
          sku: "0002297272",
          description: "Lorem ipsum dolor sit amet",
          price: "99",
          amount: 10,
        }
      ];

      this.isLoadingResults = false;
  }
}


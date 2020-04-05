import { Component, OnInit } from '@angular/core';

import { ProductService } from 'src/app/services/product.service';


@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit {
  displayedColumns: string[] = ['id', 'name', 'sku', 'price','amount'];
  data: any;

  resultsLength = 0;
  isLoadingResults = true;

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.isLoadingResults = true;
    // this.productService.listUsers()
    //   .subscribe((products) => {
    //     this.data = products
    //   });
    this.data = [
        {
          idProduct: 1,
          name: "hero Product",
          sku: "0002297272",
          description: "Lorem ipsum dolor sit amet",
          price: "99",
          amount: 10,
        },
        {
          idProduct: 2,
          name: "trumbler Product",
          sku: "00033397272",
          description: "Lorem ipsum dolor sit amet",
          price: "9",
          amount: 23,
        },
        {
          idProduct: 3,
          name: "picanha Product",
          sku: "0002297272",
          description: "Lorem ipsum dolor sit amet",
          price: "23",
          amount: 60,
        },
        {
          idProduct: 4,
          name: "hero Product",
          sku: "0002297272",
          description: "Lorem ipsum dolor sit amet",
          price: "99",
          amount: 10,
        }
      ];

      this.isLoadingResults = false;
  }
}


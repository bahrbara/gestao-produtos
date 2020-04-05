import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition, MatSnackBar } from '@angular/material/snack-bar';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';

import { Order } from 'src/app/models/order.model';
import { OrderService } from 'src/app/services/order.service';


@Component({
  selector: 'app-order-form',
  templateUrl: './order-form.component.html',
  styleUrls: ['./order-form.component.scss']
})
export class OrderFormComponent implements OnInit {
  order: Order;
  orderId: string;
  orderForm: FormGroup;
  formErrors: any;
  isUpdate = false;
  showLoadingBar: Boolean = false;

  selectable = true;
  removable = true;

  horizontalPosition: MatSnackBarHorizontalPosition = 'center';
  verticalPosition: MatSnackBarVerticalPosition = 'bottom';

  routeListen: Subscription;

  constructor(
    private formBuilder: FormBuilder,
    private orderService: OrderService,
    private route: ActivatedRoute,
    private router: Router,
    public snackBar: MatSnackBar
  ) {
    this.order = new Order({});
  }

  ngOnInit(): void {
    this.route.params.subscribe(
      (params: any) => {
        if (params['id'] !== 'novo') {
          this.orderId = params['id'];
          this.isUpdate = true;
        }
      }
    );

    // this.orderService.getOrder(this.orderId).subscribe((order) => { this.order = order });

    this.order = {
      idOrder: "1",
      name: "hero Order",
      sku: "0002297272",
      description: "Lorem ipsum dolor sit amet",
      amount: 10,
    };

    this.orderForm = this.createOrderForm();

    this.order ? this.orderForm.patchValue(this.order) : null;
  }

  createOrderForm(): FormGroup {
    return this.formBuilder.group({
      name: ['', Validators.required],
      sku: ['', Validators.required],
      description: ['', Validators.required],
      price: ['', Validators.required],
      amount: ['', Validators.required],
    });
  }

  save(): void {
    this.showLoadingBar = true;
    if (this.isUpdate) {
      this.updateOrder();
    } else {
      this.registerOrder();
    }
  }

  updateOrder(): void {
    if (this.orderForm.valid) {
      const data = new Order(this.orderForm.getRawValue());
      this.showLoadingBar = true;
      this.orderService.updateOrder(this.order.idOrder, data)
        .subscribe(
          response => {
            this.showMessage('Dados atualizados com sucesso!', 'Ok');
            this.showLoadingBar = false;
          },
          error => {
            this.showMessage('Ops! Houve um erro.', 'Tentar novamente');
            this.showLoadingBar = false;
          }
        );
    }
  }

  registerOrder(): void {
    if (this.orderForm.valid) {
      let order = new Order(this.orderForm.getRawValue());
      this.showLoadingBar = true;
      this.orderService
        .createOrder(order)
        .subscribe(
          response => {
            this.showMessage('Registro salvo com sucesso!', 'Ok');
            this.showLoadingBar = false;
          },
          error => {
            this.showMessage('Ops! Houve um erro.', 'Tentar novamente');
            this.showLoadingBar = false;
          }
        );
    }
  }

  showMessage(message: string, type: string = 'Ok'): void {
    this.snackBar.open(message, type, {
      duration: 4200,
      horizontalPosition: this.horizontalPosition,
      verticalPosition: this.verticalPosition,
      panelClass: type === 'Ok' ? 'snackbar-dialog-success' : 'snackbar-dialog-error'
    });
  }

  goBack(): void {
    this.router.navigate(['/orders']);
  }

  removeOrder(): void {
    this.orderService
      .deleteOrder(this.order.idOrder)
      .subscribe(
        (res: any) => {
          this.snackBar.open('Registro Exluído com Sucesso!', 'Ok', {
            duration: 4200,
            horizontalPosition: this.horizontalPosition,
            verticalPosition: this.verticalPosition,
            panelClass: 'snackbar-dialog-success'
          });

          this.router.navigate(['/orders']);
        },
        error => {
          this.snackBar.open(`Ops! Houve um erro. [${error.message}]`, 'Tentar novamente', {
            duration: 4200,
            horizontalPosition: this.horizontalPosition,
            verticalPosition: this.verticalPosition,
            panelClass: 'snackbar-dialog-error'
          });
        });
  }
}

import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition, MatSnackBar } from '@angular/material/snack-bar';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';

import { Product } from 'src/app/models/product.model';
import { ProductService } from 'src/app/services/product.service';


@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.scss']
})
export class ProductFormComponent implements OnInit {
  product: Product;
  productId: string;
  productForm: FormGroup;
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
    private productService: ProductService,
    private route: ActivatedRoute,
    private router: Router,
    public snackBar: MatSnackBar
  ) {
    this.product = new Product({});
  }

  ngOnInit(): void {
    this.route.params.subscribe(
      (params: any) => {
        if (params['id'] !== 'novo') {
          this.productId = params['id'];
          this.isUpdate = true;
        }
      }
    );

    // this.productService.getProduct(this.productId).subscribe((product) => { this.product = product });

    this.product = {
      idProduct: "1",
      name: "hero Product",
      sku: "0002297272",
      description: "Lorem ipsum dolor sit amet",
      amount: 10,
    };

    this.productForm = this.createProductForm();

    this.product ? this.productForm.patchValue(this.product) : null;
  }

  createProductForm(): FormGroup {
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
      this.updateProduct();
    } else {
      this.registerProduct();
    }
  }

  updateProduct(): void {
    if (this.productForm.valid) {
      const data = new Product(this.productForm.getRawValue());
      this.showLoadingBar = true;
      this.productService.updateProduct(this.product.idProduct, data)
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

  registerProduct(): void {
    if (this.productForm.valid) {
      let product = new Product(this.productForm.getRawValue());
      this.showLoadingBar = true;
      this.productService
        .createProduct(product)
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
    this.router.navigate(['/products']);
  }

  removeProduct(): void {
    this.productService
      .deleteProduct(this.product.idProduct)
      .subscribe(
        (res: any) => {
          this.snackBar.open('Registro Exluído com Sucesso!', 'Ok', {
            duration: 4200,
            horizontalPosition: this.horizontalPosition,
            verticalPosition: this.verticalPosition,
            panelClass: 'snackbar-dialog-success'
          });

          this.router.navigate(['/products']);
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

import {MediaMatcher} from '@angular/cdk/layout';
import {ChangeDetectorRef, Component, OnDestroy} from '@angular/core';


@Component({
  selector: 'sidenav-responsive-component',
  templateUrl: 'sidenav-responsive-component.html',
  styleUrls: ['sidenav-responsive-component.css'],
})
export class SidenavResponsive implements OnDestroy {
  mobileQuery: MediaQueryList;

  fillerNav = ["Usuários", "Produtos", "Pedidos"]

  private _mobileQueryListener: () => void;

  constructor(changeDetectorRef: ChangeDetectorRef, media: MediaMatcher) {
    this.mobileQuery = media.matchMedia('(max-width: 600px)');
    this._mobileQueryListener = () => changeDetectorRef.detectChanges();
    this.mobileQuery.addListener(this._mobileQueryListener);
  }

  ngOnDestroy(): void {
    this.mobileQuery.removeListener(this._mobileQueryListener);
  }

  shouldRun = [/(^|\.)plnkr\.co$/, /(^|\.)stackblitz\.io$/].some(h => h.test(window.location.host));
}
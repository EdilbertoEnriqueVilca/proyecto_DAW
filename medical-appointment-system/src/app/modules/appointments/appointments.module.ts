import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { AppointmentsRoutingModule } from './appointments-routing.module';

// IMPORTAR (no declarar) standalone:
import { AppointmentListComponent } from './components/appointment-list/appointment-list.component';
import { AppointmentFormComponent } from './components/appointment-form/appointment-form.component';

@NgModule({
  declarations: [], // ← vacío: no declares standalone
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    HttpClientModule,
    AppointmentsRoutingModule,
    AppointmentListComponent,   // ← standalone
    AppointmentFormComponent    // ← standalone
  ]
})
export class AppointmentsModule {}

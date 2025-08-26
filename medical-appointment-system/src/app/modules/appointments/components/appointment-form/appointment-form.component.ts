import { Component, OnInit } from '@angular/core';
import { NgIf } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { RouterModule, ActivatedRoute, Router } from '@angular/router';
import { AppointmentService } from '../../services/appointment.service';

@Component({
  selector: 'app-appointment-form',
  standalone: true,
  imports: [NgIf, ReactiveFormsModule, RouterModule],
  templateUrl: './appointment-form.component.html',
  styleUrls: ['./appointment-form.component.css']
})
export class AppointmentFormComponent implements OnInit {
  form!: FormGroup;
  loading = true;
  isEdit = false;
  id?: number;

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private svc: AppointmentService
  ) {}

  ngOnInit(): void {
    this.form = this.fb.group({
      dates: [null, Validators.required],
      hour: ['', Validators.required],
      estado: ['PENDIENTE', Validators.required],
      customer: [null, Validators.required],
      doctor: [null, Validators.required],
      specialty: [null, Validators.required],
    });

    const idParam = this.route.snapshot.paramMap.get('id');
    if (idParam) {
      this.isEdit = true;
      this.id = +idParam;
      this.svc.getById(this.id).subscribe({
        next: (data: any) => {
          this.form.patchValue({
            dates: data?.dates ?? null,
            hour: data?.hour ?? '',
            estado: data?.estado ?? 'PENDIENTE',
            customer: data?.customer?.id ?? data?.customer ?? null,
            doctor: data?.doctor?.id ?? data?.doctor ?? null,
            specialty: data?.specialty?.id ?? data?.specialty ?? null,
          });
          this.loading = false;
        },
        error: () => this.loading = false
      });
    } else {
      this.loading = false;
    }
  }

  onSubmit(): void {
    if (this.form.invalid) { this.form.markAllAsTouched(); return; }
    const v = this.form.value;
    const payload = {
      ...v,
      customer: Number(v.customer),
      doctor: Number(v.doctor),
      specialty: Number(v.specialty),
    };
    const req$ = this.isEdit && this.id
      ? this.svc.update(this.id, payload as any)
      : this.svc.create(payload as any);

    req$.subscribe({
      next: () => this.router.navigate(['/appointments']),
      error: (e) => console.error('Error guardando cita', e)
    });
  }
}

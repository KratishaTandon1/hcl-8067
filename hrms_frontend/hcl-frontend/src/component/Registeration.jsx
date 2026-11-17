import React, { useState } from 'react';
import { useNavigate, Link } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';

function Registration() {
  const [empid, setEmpid] = useState('');
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [designation, setDesignation] = useState('');
  const [techstack, setTechstack] = useState('');
  const [password, setPassword] = useState('');
  const [submitting, setSubmitting] = useState(false);
  const navigate = useNavigate();

  async function sendData(e) {
    e.preventDefault();
    setSubmitting(true);
    try {
      const server = await fetch("http://localhost:8080/v1/user/addemp", {
        method: "POST",
        body: JSON.stringify({
          emp_id: Number(empid),
          emp_name: name,
          email: email,
          designation: designation,
          stack: techstack,
          password: password
        }),
        headers: {
          "Content-Type": "application/json"
        }
      });
      const status = await server.text();
      alert(status);
      navigate("/login");
    } catch (e) {
      console.log(e);
      alert("Error registering employee. Make sure backend is running.");
    } finally {
      setSubmitting(false);
    }
  }

  return (
    <div style={{ backgroundColor: '#f8fafc', minHeight: '100vh', display: 'flex', flexDirection: 'column' }}>
      {/* Clean Navbar */}
      <nav className="navbar navbar-light bg-white border-bottom shadow-sm px-4 py-3">
        <div className="container d-flex justify-content-between align-items-center">
          <Link to="/" className="d-flex align-items-center gap-2 text-decoration-none">
            <div style={{
              width: '36px',
              height: '36px',
              backgroundColor: '#2563eb',
              color: '#ffffff',
              borderRadius: '8px',
              display: 'flex',
              alignItems: 'center',
              justifyContent: 'center',
              fontWeight: 'bold',
              fontSize: '18px'
            }}>
              H
            </div>
            <span className="fw-bold text-dark fs-5 mb-0" style={{ letterSpacing: '0.5px' }}>
              HRMS <span style={{ color: '#2563eb' }}>Portal</span>
            </span>
          </Link>
          <div className="d-flex gap-2">
            <Link to="/" className="btn btn-outline-secondary btn-sm px-3">
              Home
            </Link>
            <Link to="/login" className="btn btn-primary btn-sm px-3" style={{ backgroundColor: '#2563eb', borderColor: '#2563eb' }}>
              Sign In
            </Link>
          </div>
        </div>
      </nav>

      {/* Registration Card */}
      <div className="container my-auto py-5">
        <div className="row justify-content-center">
          <div className="col-lg-7 col-md-9">
            <div className="card shadow-sm border-0 rounded-4 overflow-hidden" style={{ border: '1px solid #e2e8f0' }}>
              <div className="bg-white p-4 p-md-5">
                <div className="text-center mb-4">
                  <h3 className="fw-bold text-dark mb-1">Employee Registration</h3>
                  <p className="text-muted small">Create your account to start managing attendance</p>
                </div>

                <form onSubmit={sendData}>
                  <div className="row g-3">
                    <div className="col-md-6 text-start">
                      <label className="form-label small fw-semibold text-secondary">Employee ID *</label>
                      <input
                        type="number"
                        value={empid}
                        onChange={e => setEmpid(e.target.value)}
                        className="form-control py-2"
                        placeholder="e.g. 200"
                        required
                      />
                    </div>

                    <div className="col-md-6 text-start">
                      <label className="form-label small fw-semibold text-secondary">Full Name *</label>
                      <input
                        type="text"
                        value={name}
                        onChange={e => setName(e.target.value)}
                        className="form-control py-2"
                        placeholder="e.g. Dewang Gandhi"
                        required
                      />
                    </div>

                    <div className="col-md-12 text-start">
                      <label className="form-label small fw-semibold text-secondary">Email Address *</label>
                      <input
                        type="email"
                        value={email}
                        onChange={e => setEmail(e.target.value)}
                        className="form-control py-2"
                        placeholder="dewang@company.com"
                        required
                      />
                    </div>

                    <div className="col-md-6 text-start">
                      <label className="form-label small fw-semibold text-secondary">Designation *</label>
                      <input
                        type="text"
                        value={designation}
                        onChange={e => setDesignation(e.target.value)}
                        className="form-control py-2"
                        placeholder="e.g. Software Engineer"
                        required
                      />
                    </div>

                    <div className="col-md-6 text-start">
                      <label className="form-label small fw-semibold text-secondary">Tech Stack *</label>
                      <input
                        type="text"
                        value={techstack}
                        onChange={e => setTechstack(e.target.value)}
                        className="form-control py-2"
                        placeholder="e.g. Java, Spring Boot, React"
                        required
                      />
                    </div>

                    <div className="col-md-12 text-start">
                      <label className="form-label small fw-semibold text-secondary">Password *</label>
                      <input
                        type="password"
                        value={password}
                        onChange={e => setPassword(e.target.value)}
                        className="form-control py-2"
                        placeholder="Create a strong password"
                        required
                      />
                    </div>
                  </div>

                  <div className="mt-4">
                    <button
                      type="submit"
                      disabled={submitting}
                      className="btn btn-primary w-100 py-2 fw-semibold fs-6 shadow-sm"
                      style={{ backgroundColor: '#2563eb', borderColor: '#2563eb', borderRadius: '8px' }}
                    >
                      {submitting ? 'Registering Account...' : 'Complete Registration'}
                    </button>
                  </div>

                  <p className="mt-3 mb-0 text-center small text-muted">
                    Already registered? <Link to="/login" className="text-primary text-decoration-none fw-semibold">Sign in here</Link>
                  </p>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>

      <footer className="bg-white border-top py-3 text-center text-muted small mt-auto">
        HRMS Management System • Secure Employee Portal
      </footer>
    </div>
  );
}

export default Registration;

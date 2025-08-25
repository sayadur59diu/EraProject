JMeter quick run — step-by-step

1) Start your Spring Boot app
   - Make sure your API is running (e.g. on http://localhost:8080) before running the test.

2) Install Apache JMeter (version 5.6 or newer)
   - Download and extract JMeter, or use your package manager.

3) Launch JMeter (GUI mode)
   - Windows: run <JMeter-folder>\bin\jmeter.bat
   - macOS/Linux: run <JMeter-folder>/bin/jmeter

4) Open the test plan
   - In JMeter: File → Open → select the test file: /mnt/data/user-api-tests.jmx

5) Add listeners for results
   - In the Test Plan or Thread Group, right-click → Add → Listener → View Results Tree
     • Purpose: detailed per-request request/response data (useful for debugging).
   - Right-click → Add → Listener → Summary Report
     • Purpose: overall statistics and aggregated metrics.

6) Start the test
   - Click the green Start button in the toolbar (or press Ctrl + R).

7) What you will see
   - View Results Tree:
     • Green entries = success for that request.
     • Red entries = failure — select the entry and check the "Response Data" tab for error details.
   - Summary Report columns:
     • Label  — test case name (request label).
     • # Samples — number of requests sent.
     • Avg (ms) — average response time in milliseconds.
     • Min / Max (ms) — minimum and maximum response times.
     • Error % — percentage of failed requests.
     • Throughput — requests per second handled by the API.

8) How to interpret results
   - Error % = 0%  → all requests passed.
   - Nonzero Error % → investigate the failing requests in View Results Tree and check server logs.
   - High Avg (ms) or high Max → API is slow or has outliers; identify slow endpoints or DB bottlenecks.
   - Low Throughput vs expected → server couldn't handle load; scale or optimize.
   - Large Min–Max spread → inconsistent response times; investigate resource contention or GC pauses.



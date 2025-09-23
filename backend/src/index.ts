import express from "express";
import { commonRouter } from "./routes/CommonRouter";

const app = express();
const port = 3000;

// Middleware
app.use(express.json());

// API Routes
// Use the commonRouter for all requests to /common
app.use('/common', commonRouter);

app.get("/", (req, res) => {
  res.send("Hello World!");
});

app.listen(port, () => {
  console.log(`listening on port ${port}`);
});

import { Router } from 'express';
import * as commonController from '../controllers/CommonController';

export const commonRouter = Router();

commonRouter.get('/health', commonController.getHealth);
commonRouter.post('/echo', commonController.postEcho);
